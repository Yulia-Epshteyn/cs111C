package Assignments.AssignmentB;

/**
 * An interface for the ADT list, where a user can only access the beginning and ending elements of a list.
 * @author Yulia Bugrova
 */
public interface EntryWayListInterface<T>
{
    /** Adds a new entry to the beginning of this list.
     Entries originally at and above the first position
     are at the next higher position within the list.
     The list's size is increased by 1.
     * @param newEntry The object to be added as a new entry.
     * @return True if the addition was successful, or false if not.*/
  public boolean insertHead(T newEntry);


    /** Adds a new entry to the end of this list.
     Entries currently in the list are unaffected.
     The list's size is increased by 1.
     * @param newEntry The object to be added as a new entry.
     * @return True if the addition was successful, or false if not.*/
  public boolean insertTail(T newEntry);


    /** Removes the first entry from this list.
     * @return Either the removed entry, if the removal was successful, or null.*/
  public T deleteHead();


    /**Removes the last entry from this list.
     * @return Either the removed entry, if the removal was successful, or null.*/
  public T deleteTail();


    /** Retrieves all entries that are in this list in the order in which
     they occur in the list.*/
  public void display();


    /** Sees whether this list contains a given entry.
     * @param anEntry The object that is the desired entry.
     * @return An integer that indicates the position of
    the desired entry.*/
  public int contains(T anEntry);


    /**Sees whether this list is empty.
     * @return True if the list is empty, or false if not.*/
  public boolean isEmpty();

    /** Sees whether this list is full.
     * @return True if the list is full, or false if not.*/

  public boolean isFull();


} // end EntryWayListInterface

