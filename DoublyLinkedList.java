public class DoublyLinkedList {
    private DoublyLinkedListItem first;
    private DoublyLinkedListItem last;

    public DoublyLinkedListItem getFirst() {
        return first;
    }

    public DoublyLinkedListItem getLast() {
        return last;
    }

    public DoublyLinkedList(){
        first = null;
        last = null;
    }
     
    public void AddFirst(DoublyLinkedListItem item){
        DoublyLinkedListItem newItem  = item;
        if (first == null){
            first = newItem;
            last = newItem;
        } else {
            newItem.setNext(first);
            first.setPrevious(newItem);
            first = newItem; 
        }
    }

    public void AddLast(DoublyLinkedListItem item){
        DoublyLinkedListItem newItem  = item;
        if (first == null){
            first = newItem;
            last =newItem;
        } else{
            last.setNext(newItem);
            newItem.setPrevious(last);
            last = newItem; 
        }
    }

    public void AddAfter(DoublyLinkedListItem afterItem, DoublyLinkedListItem newItem){
        if(Contains(afterItem)){
            DoublyLinkedListItem newItemNode  = newItem;
            DoublyLinkedListItem current = first;
			if (afterItem.Value == current.Value) AddFirst(newItem);
            while (current.GetNext() != null){
                if (afterItem.Value == current.Value) {
                    AddAfterChange(current,newItemNode);
                }
                current = current.GetNext();
            }
            if (afterItem.Value == current.Value){
                AddLast(newItem);
            }
        }
    }

    public void AddAfterChange(DoublyLinkedListItem current, DoublyLinkedListItem newItem){
        current.GetNext().setPrevious(newItem);
        newItem.setNext(current.GetNext());
        
        current.setNext(newItem);
        newItem.setPrevious(current);
        return;
    }

    public void AddBefore(DoublyLinkedListItem beforeItem, DoublyLinkedListItem newItem){
        if(Contains(beforeItem)){
            DoublyLinkedListItem newItemNode  = newItem;
            DoublyLinkedListItem current = first;
			if (beforeItem.Value == current.Value) AddFirst(newItem);
            while (current.GetNext() != null){
                if (beforeItem.Value == current.Value)AddBeforeChange(beforeItem,newItemNode);
                current = current.GetNext();
            }
            if (beforeItem.Value == current.Value) AddLast(newItem);
        
        }
    }
    public void AddBeforeChange(DoublyLinkedListItem beforeItem, DoublyLinkedListItem newItemNode){
        beforeItem.GetPrev().setNext(newItemNode);
        newItemNode.setNext(beforeItem);

        newItemNode.setPrevious(beforeItem.GetPrev());
        beforeItem.setPrevious(newItemNode);
        return;
    }
    

    public void Clear(){
        first = null;
        last = null;
    }

    public boolean Contains(DoublyLinkedListItem item){
        DoublyLinkedListItem current  = first;
        while (current.GetNext() != null){
            if (item.Value == current.Value) return true;
            current = current.GetNext();
        }
		if (item.Value == current.Value) return true;
        return false;
    }

    public void Remove(DoublyLinkedListItem item){
        if (Contains(item)){
            DoublyLinkedListItem current = first;
			if (item.Value == current.Value)RemoveFirst();
			current = current.GetNext();
            while (current.GetNext() != null){
                if (item.Value == current.Value){
                    current.GetPrev().setNext(current.GetNext());
                    current.GetNext().setPrevious(current.GetPrev());
                    
                    current.setNext(null);
                    current.setPrevious(null);
					return;
                }
                current = current.GetNext();
            }
			if (item.Value == current.Value) RemoveLast();
        }
        
    }
	

    public void RemoveFirst(){
        first.GetNext().setPrevious(null);
        first = first.GetNext();
		return;
    }

    public void RemoveLast(){
        last = last.GetPrev();
        last.setNext(null);
		return;
    }


}
