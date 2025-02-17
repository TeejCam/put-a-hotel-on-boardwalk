package org.example;

public class GenericCircularLinkedList<T> {
    GenericNode<T> last;
    GenericNode<T> currentNode;

    public GenericCircularLinkedList(GenericNode<T> last)
    {
        this.last = last;
        this.currentNode = (last != null) ? last.next : null;
        if(this.last != null){
            this.last.next = last;
        }
    }

    public void append(GenericNode<T> data)
    {
        if(last == null){
            data.next = data;
            last = data;
            currentNode = data;
        } else {
            data.next = last.next;
            last.next = data;
            last = data;
        }
    }

    public void prepend(GenericNode<T> data)
    {
        if(last == null){
            data.next = data;
            last = data;
            currentNode = data;
        } else {
            data.next = last.next;
            last.next = data;
        }
    }

    public void insertAfter(GenericNode<T> insertAfter, GenericNode<T> data)
    {
        if(last != null){
            GenericNode<T> temp = last;
            do{
                if(temp.data == insertAfter){
                    //GenericNode n = new GenericNode<>((T) data);
                    data.next = temp.next;
                    temp.next = data;
                    break;
                }
                temp = temp.next;
            } while(temp != last);
        }
    }

    public GenericNode<T> deleteLast()
    {
        if(last == null){
            return null;
        }
        if(last.next == last){
            GenericNode<T> toDelete = last;
            last = null;
            currentNode = null;
            return toDelete;
        }
        GenericNode<T> temp = last.next;
        while(temp.next != last){
            temp = temp.next;
        }
        GenericNode<T> toDelete = last;
        temp.next = last.next;
        last = temp;
        return toDelete;
    }

    public GenericNode<T> deleteStart()
    {
        if(last == null){
            return null;
        }
        if(last.next == last){
            GenericNode<T> toDelete = last;
            last = null;
            currentNode = null;
            return toDelete;
        }
        GenericNode<T> toDelete = last.next;
        last.next = toDelete.next;
        return toDelete;
    }

    public boolean deleteAfter(GenericNode<T> data)
    {
        if(last == null) {return false;}
    
        GenericNode<T> temp = last;
        do{
            if(temp.data == data){
                GenericNode<T> toDelete = temp.next;
                if(toDelete == temp){
                    last = null;
                    currentNode = null;
                    return true;
                }
                temp.next = toDelete.next;
                if(toDelete == last){
                    last = temp;
                }
                return true;
            }
            temp = temp.next;
        } while(temp != last);
        return false; 
    }

    public T getCurrentData()
    {
        if(currentNode == null){
            throw new IllegalStateException("Couldn't find current node.");
        }
        return currentNode.data;
    }

    public boolean step()
    {
        if(currentNode != null){
            currentNode = currentNode.next;
            if(currentNode == last.next){
                currentNode = last.next;
            }
            return true;
        }
        return false;
    }

    public void startFromBeginning(){
        this.currentNode = (last != null) ? last.next : null;
    }

    public void display()
    {
        if(last == null){
            System.out.println("List is empty!");
        }

        GenericNode<T> current = last.next;
        while(current != last){
            System.out.println(current.data);
            current = current.next;
        }

        System.out.println(current.data);
    }

    
}