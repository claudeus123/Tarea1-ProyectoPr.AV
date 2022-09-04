class Main {
	public static void main(String[] args) {
		DoublyLinkedListItem item1 = new DoublyLinkedListItem(1);
		DoublyLinkedListItem item2 = new DoublyLinkedListItem(2);
		DoublyLinkedListItem item3 = new DoublyLinkedListItem(3);
		DoublyLinkedListItem item4 = new DoublyLinkedListItem(4);
		DoublyLinkedListItem item5 = new DoublyLinkedListItem(5);

		DoublyLinkedList list = new DoublyLinkedList();
		list.AddLast(item3);
		list.AddFirst(item1);
		list.AddFirst(item2);
		list.AddLast(item4);
		list.AddAfter(item4,item5);
		
		list.Remove(item3); 
		DoublyLinkedListItem first = list.getFirst();

		System.out.println(first.getValue());
		while (first.GetNext() != null) {
			first = first.GetNext();
			System.out.println(first.getValue());
		}
		System.out.println(list.Contains(item4));
	
	}
}