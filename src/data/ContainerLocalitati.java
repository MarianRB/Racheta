package data;

import java.util.Iterator;

public class ContainerLocalitati {
	
	private Node head;
	private int nrl;
	
	private class Node
	{
		public CLocalitate localitate;
		public Node next;
	}
	
	private class IteratorLoc implements Iterator
	{
		Node itr ;
		public IteratorLoc()
		{
			this.itr = head;
		}
		
		@Override
		public boolean hasNext() {
			if(itr == null)
			{
				return false;
			}
			else
			{
				return true;
			}
		}

		@Override
		public CLocalitate next() {
			if(this.hasNext())
			{
				Node node = itr;
				itr = itr.next;
				return node.localitate;
			}
			return null;
		}
		
	}
	
	public Iterator getIterator()
	{
		return new IteratorLoc();
	}
	
	public ContainerLocalitati()
	{
		this.head = null;
		this.nrl = 0;
	}
	
	public void adauga(CLocalitate loc)
	{
		Node new_node = new Node();
		new_node.localitate = loc;
		new_node.next = null;
		this.nrl ++ ;
		
		if(this.head == null)
		{
			this.head = new_node;
		}
		else
		{
			Node itr = head;
			while(itr.next != null)
			{
				itr = itr.next;
			}
			itr.next = new_node;
			
		}
	}
}
