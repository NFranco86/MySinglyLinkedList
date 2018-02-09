public class MySinglyLinkedList<E> {
	Node head;

	public MySinglyLinkedList() {
		head = new Node();
	}

	class Node {
		E data;
		Node next;

		public Node() {
			data = null;
			next = null;
		}

		public Node(E newData, int index) {
			Node current = head;
			int counter = 1;
			while (counter - 1 != index) {
				current = current.next;
			}
			data = newData;
			this.next = current.next;
			current.next = this;
		}
	}

	// Size method needed for the add function check

	public int size() {
		if (head.next == null) {
			return 0;
		}
		Node current = head.next;
		int counter = 1;
		while (current.next != null) {
			current = current.next;
			counter++;
		}
		return counter;
	}

	// Beginning Method Implementation

	// Starting with addFirst method

	public void addFirst(E item) {
		Node newNode = new Node();
		newNode.data = item;
		// If list is empty check
		if (head == null) {
			head.next = newNode;
			return;
		}
		// At least 1 element inside the list
		newNode.next = head.next;
		head.next = newNode;
	}

	// Next we insert the addLast method

	public void addLast(E item) {
		Node lastNode = new Node();
		lastNode.data = item;
		// If list is empty check
		if (head == null) {
			head = lastNode;
			return;
		}
		// At least 1 element inside the list
		Node last = head;
		while (last.next != null)
			last = last.next;
		last.next = lastNode;

		System.out.println();
	}

	// Finally, we have the "add" method

	public void add(E item, int index) {
		// Checks to avoid null pointer exceptions
		if (index < 0 || index > size()) {
			System.out.println("That's not a valid index, sorry");
			return;

			// Checks using our previous add methods for when the add
			// method is basically acting as the addFirst and addLast methods

		} else if (index == 0) {
			addFirst(item);
		} else if (index == size()) {
			addLast(item);
		} else {

			// If the index passes through these 3 tests, then it
			// finally can proceed to the code below for add

			Node current = head.next;
			int counter = 1;
			while (counter != index - 1) {
				current = current.next;
				counter++;
			}

			// You can use this greyed out code to
			// double check your position
			// System.out.println();
			// System.out.println("Current positon is " + current.data);
			// System.out.println();

			Node new_node = new Node();
			new_node.next = current.next;
			current.next = new_node;
			new_node.data = item;
		}
	}

	// Now we start inserting the remove methods, complete with checks ^_^

	public void removeFirst() {
		if (head == null || head.next == null) {
			return;
		} else {
			Node temp = head;
			head = head.next;
			temp.next = null;
			
	/*A small two lines of code if you want to see when this method is used
	  System.out.println();
	  System.out.println("You just removed the original first node");*/
		}
	}

	public void removeLast() {
		if (head == null || head.next == null) {
			return;
		} else {
			Node current = head;
			while (current.next.next != null) {
				current = current.next;
			}
			current.next = null;
			// You can use these two greyed out lines
			// to double that you actually removed the last node
			// System.out.println();
			// System.out.println("You just removed the last node");
		}
	}

	public void remove(int index) {
		if (index < 0 || index > size()) {
			System.out.println("Error...This wish cannon be granted...");
			return;
		}
		if (index == 0) {
			removeFirst();
		} else if (index == size()) {
			removeLast();
		} else {

			// If the index passes through these 3 tests, then it
			// finally can proceed to the code below for add

			Node current = head;
			Node deleted_node = null;
			int counter = 0;
			while (counter != index) {
				deleted_node = current;
				current = current.next;
				counter++;
			}
			/*
			 * This code below that is greyed out is an extra check to make sure the person
			 * you want to remove is actually the one selected to be removed
			 * System.out.println(); System.out.println("Current positon is " +
			 * current.data); System.out.println();
			 */
			deleted_node.next = current.next;
		}
	}

	// Now we are going to change the
	// item or what is printed out
	// while leaving the index intact

	public void change(E item, int index) {
		if (head == null || head.next == null) {
			return;
		} else {
			Node current = head.next;
			int counter = 0;
			while (counter != index) {
				current = current.next;
				counter++;
			}
			current.data = item;
		}
	}

	public void traverse() {
		if (head.next == null) {
			System.out.println("You don't have any listed warriors, better wish for some with the Dragon Balls");
			return;
		}
		Node current = head.next;
		while (current.next != null) {
			System.out.println(current.data);
			current = current.next;
		}
		System.out.println(current.data);
	}

	public static void main(String[] args) {
		MySinglyLinkedList<String> list = new MySinglyLinkedList<String>();
		System.out.println("Get ready for Dragon Ball Z Story! First we need to introduce our characters!");
		System.out.println("");
		list.addFirst("Tien");
		list.addFirst("Krillin");
		list.addFirst("Gohan");
		list.addFirst("Goku");
		list.traverse();
		System.out.println("");
		System.out.println("I could've sworn we had more than " + list.size() + " warriors on our list...");
		System.out.println("Oh yeah, we forgot about Yamcha! Better put him at the end of the list.");
		list.addLast("Yamcha");
		list.traverse();
		System.out.println("");
		System.out.println("Now our list of warriors is " + list.size() + ".");
		System.out.println("What? Piccolo is a good guy now? Guess we should add him next to Gohan on the list.");
		System.out.println("");
		list.add("Piccolo", 3);
		list.traverse();
		System.out.println("");
		System.out.println("With Piccolo on our side now, our list of warriors is " + list.size() + ".");
		System.out.println("Oh no!! Random bad guys just appeared! And it looks like Tien got killed! Guess he's off the list now.");
		System.out.println("");
		list.remove(5);
		list.traverse();
		System.out.println("");
		System.out.println(
		"Now our list of warriors is down to " + list.size() + ". I sure hope nothing happens to Yamcha...");
		System.out.println(
		"Whoops... like we jinxed Yamcha. He is no longer with us...but is it really a surprise...");
		System.out.println("");
		list.removeLast();
		list.traverse();
		System.out.println("");
		System.out.println(
		"This isn't good, the baddies have shrunk our list of warriors to " + list.size() + " and it looks like they want Goku next...");
		System.out.println("Yikes!! The bad guys just kicked Goku 10,000 miles away! Guess he's off the list for now...");
		System.out.println("");
		list.removeFirst();
		list.traverse();
		System.out.println("");
		System.out.println("Our " + list.size() + " warriors are barely hanging on, and the bad guys just ganged up on Krillin!!");
		System.out.println("");
		list.addFirst("Goku");
		list.traverse();
		System.out.println("");
		System.out.println("Goku made it back into the fight, but unfortunately his best friend Krillin was killed shortly after his arrival...");
		System.out.println("");
		list.removeLast();
		list.traverse();
		System.out.println("");
		System.out.println("Something is happening to Goku...his friend's death seems to have push him over the edge...making him...change...");
		System.out.println("");
		list.change("Legendary Super Saiyan Goku", 0);
		list.traverse();
		System.out.println("");
		System.out.println("Goku changed into a Legendary Super Saiyan??!! He easliy defeated the baddies with a huge kamehameha blast");
		System.out.println("Once again the day was saved and the warriors who died were wished back with the Dragon Balls");
		System.out.println("Thanks for reading this super long story, hope you enjoyed it!!");
	}
}
