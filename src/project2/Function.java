/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2;

/**
 *
 * @author Vinh
 */
public interface Function<E> {
    public void delete();
    public E searchByID(String id);
    public boolean isIdDuplicate(String ID);
    public int size();
    public void print();
}
