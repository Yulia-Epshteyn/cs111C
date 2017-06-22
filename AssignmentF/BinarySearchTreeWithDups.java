
package Assignments.AssignmentF;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Stack;

public class BinarySearchTreeWithDups<T extends Comparable<? super T>> extends BinarySearchTree<T>
		implements SearchTreeInterface<T>, java.io.Serializable {

	public BinarySearchTreeWithDups() {
		super();
	}

	public BinarySearchTreeWithDups(T rootEntry) {
		super(rootEntry);
		setRootNode(new BinaryNode<T>(rootEntry));
	}

	@Override
	public T add(T newEntry) {
		T result = null;
		if (isEmpty())
			setRootNode(new BinaryNode<T>(newEntry));
		else
			result = addEntryHelperIterative(newEntry);
		return result;
	}

	// IMPORTANT: METHOD MUST BE ITERATIVE!!
	private T addEntryHelperIterative(T newEntry) {
		BinaryNodeInterface<T> currentNode = getRootNode();

		T result = null;
		boolean found = false;

		while (!found) {
			T currentEntry = currentNode.getData();
			//System.out.println(currentNode.getData());
			int comparison = newEntry.compareTo(currentEntry);

			if (comparison == 0) { // newEntry matches currentEntry;
				if(currentNode.hasRightChild()){
					currentNode = currentNode.getRightChild();
				}
				else{
					found = true;
					currentNode.setRightChild(new BinaryNode<T>(newEntry));
					result = currentEntry;
				}

			} else if (comparison < 0) {
				if (currentNode.hasLeftChild())
					currentNode = currentNode.getLeftChild();
				else {
					found = true;
					currentNode.setLeftChild(new BinaryNode<T>(newEntry));
				} // end if
			} else {
				assert comparison > 0;
				if (currentNode.hasRightChild())
					currentNode = currentNode.getRightChild();
				else {
					found = true;
					currentNode.setRightChild(new BinaryNode<T>(newEntry));
				}
			}
		}

		return result;
	}


	public ArrayList<T> getAllEntriesIterative(T searchVal) {
		BinaryNodeInterface<T> currentNode = getRootNode() ;
		ArrayList<T> entryList = new ArrayList<T>();
		if(currentNode == null) {
			return entryList;
		}
		Stack<BinaryNodeInterface<T>> stack = new Stack<>();
		while(!stack.empty() || currentNode != null){
			if(currentNode != null){
				stack.push(currentNode);
                currentNode = currentNode.getLeftChild();
            }
			else{
				BinaryNode<T> newNode = (BinaryNode<T>) stack.pop();
				if (newNode.getData().compareTo(searchVal) == 0){
					entryList.add(searchVal);
				}
				currentNode = newNode.getRightChild();
			}
		}
		return entryList;
	}


	// ??? IMPLEMENT THIS METHOD
	public ArrayList<T> getAllEntriesRecursive(T searchVal) {
		// this initial code is meant as a suggestion to get your started- feel
		// free to use it or delete it!
		BinaryNodeInterface<T> rootNode = getRootNode();
		ArrayList<T> entryList = new ArrayList<T>();
		if (rootNode != null) {
			getAllEntriesHelper(searchVal, rootNode, entryList);
		}
		return entryList;
	}

	private void getAllEntriesHelper(T searchVal, BinaryNodeInterface<T> currentNode, ArrayList<T> entryList){
	        if(currentNode.getData().compareTo(searchVal) == 0){
	            entryList.add(searchVal);
            }
	    	if (currentNode.hasLeftChild()) {
				getAllEntriesHelper(searchVal, currentNode.getLeftChild(), entryList);
			}
			if (currentNode.hasRightChild()) {
				getAllEntriesHelper(searchVal,currentNode.getRightChild(), entryList);
			}

	}
	// ??? IMPLEMENT THIS METHOD
    // // Stack<BinaryNodeInterface<T>> nodeStack = new
    // Stack<BinaryNodeInterface<T>>();
    // nodeStack.push(getRootNode());
    // while(!nodeStack.isEmpty()) {
    // }
	public ArrayList<T> getAllEntriesLessThanIterative(T searchVal) {
		// this initial code is meant as a suggestion to get your started- feel
		// free to use it or delete it!
		ArrayList<T> entryList = new ArrayList<T>();
		BinaryNodeInterface<T> currentNode = getRootNode() ;
        Stack<BinaryNodeInterface<T>> nodeStack = new Stack<>();

        if(currentNode == null) {
            return entryList;
        }

        while(!nodeStack.empty() || currentNode != null){
            if(currentNode != null){
                nodeStack.push(currentNode);
                currentNode = currentNode.getLeftChild();
            }
            else{
                BinaryNode<T> newNode = (BinaryNode<T>) nodeStack.pop();
                if (newNode.getData().compareTo(searchVal) < 0){
                    entryList.add(newNode.getData());
                }
                currentNode = newNode.getRightChild();
            }
        }
        return entryList;

	}

	// ??? IMPLEMENT THIS METHOD
	public ArrayList<T> getAllEntriesLessThanRecursive(T searchVal) {
		// this initial code is meant as a suggestion to get your started- feel
		// free to use it or delete it!
		BinaryNodeInterface<T> rootNode = getRootNode();
		ArrayList<T> entryList = new ArrayList<T>();
		if (rootNode != null) {
            getAllEntriesLessThanHelper(searchVal, rootNode, entryList);
        }
        Collections.sort(entryList);
        return entryList;
    }



    private void  getAllEntriesLessThanHelper(T searchVal,BinaryNodeInterface<T> rootNode,ArrayList<T> entryList){
        if(rootNode.getData().compareTo(searchVal) < 0){
            entryList.add(rootNode.getData());
        }
        if (rootNode.hasLeftChild()) {
            getAllEntriesLessThanHelper(searchVal, rootNode.getLeftChild(), entryList);
        }
        if (rootNode.hasRightChild()) {
            getAllEntriesLessThanHelper(searchVal,rootNode.getRightChild(), entryList);
        }

    }
}