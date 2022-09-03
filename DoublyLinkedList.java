public class DoublyLinkedList {
    private DoublyLinkedListItem first;
    private DoublyLinkedListItem last;

    public DoublyLinkedList(){
        first = null;
        last = null;
    }
     
    public void AddFirst(DoublyLinkedListItem item){
        DoublyLinkedListItem newItem  = new DoublyLinkedListItem(item);
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
        DoublyLinkedListItem newItem  = new DoublyLinkedListItem(item);
        if (first == null){
            first = newItem;
            last =newItem;
        } else{
            last.setNext(newItem);
            newItem.setPrevious(newItem);
            last = newItem; 
        }
    }

    public void AddAfter(DoublyLinkedListItem afterItem, DoublyLinkedListItem newItem){
        if(Contains(afterItem)){
            DoublyLinkedListItem newItemNode  = new DoublyLinkedListItem(newItem);
            DoublyLinkedListItem current = first;
            while (current.GetNext() != null){
                if (afterItem.Value == current.Value) {
                    AddAfterChange(current,newItemNode);
                }
                current = current.GetNext();
            }
            if (afterItem.Value == current.Value){
                AddAfterChange(current,newItemNode);
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
            DoublyLinkedListItem newItemNode  = new DoublyLinkedListItem(newItem);
            DoublyLinkedListItem current = first;
            while (current.GetNext() != null){
                if (beforeItem.Value == current.Value)AddBeforeChange(beforeItem,newItemNode);
                current = current.GetNext();
            }
            if (beforeItem.Value == current.Value) AddBeforeChange(beforeItem,newItemNode);
        
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
        return false;
    }

    public void Remove(DoublyLinkedListItem item){
        if (Contains(item)){
            DoublyLinkedListItem current  = first;
            while (current.GetNext() != null){
                if (item.Value == current.Value);{
                    current.GetPrev().setNext(current.GetNext());
                    current.GetNext().setPrevious(current.GetPrev());
                    
                    current.setNext(null);
                    current.setPrevious(null);
                }
                current = current.GetNext();
            }
        }
        
    }

    public void RemoveFirst(){
        first.GetNext().setPrevious(null);
        first = first.GetNext();
    }

    public void RemoveLast(){
        last.GetPrev().setNext(null);
        last = last.GetNext();
    }


}
