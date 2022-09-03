public class DoublyLinkedListItem {
    public Object Value;
    private DoublyLinkedListItem next;
    private DoublyLinkedListItem  previous;

    public DoublyLinkedListItem(Object Value){
        this.Value = Value;
        this.next = null;
        this.previous = null;
    }

    // public DoublyLinkedList GetList(){
    //     
    // }

    public DoublyLinkedListItem GetNext(){
        return next;
    }

    public DoublyLinkedListItem GetPrev(){
        return previous;
    }

    public void setNext(DoublyLinkedListItem next) {
        this.next = next;
    }

    public void setPrevious(DoublyLinkedListItem previous) {
        this.previous = previous;
    }

    
}
