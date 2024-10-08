package ru.gb.family_tree.model.family_tree;

import ru.gb.family_tree.model.human.Human;
import ru.gb.family_tree.model.human.HumanComparatorById;
import ru.gb.family_tree.model.human.HumanCoparatorByBirthDate;
import ru.gb.family_tree.model.human.HumanIterator;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends FamilyTreeItem<E>> implements Serializable, Iterable<E> {
    private int genId;

    private List<E> humans;

    public FamilyTree() {
        humans = new ArrayList<>();
    }

    public void addHuman(Human human){
        humans.add((E) human);
    }

    public void addHumans(List<E> humans) {
        this.humans.addAll(humans);
    }

    public void sortByName(){
        Collections.sort(humans);
    }

    public List<E> getHumans() {
        return humans;
    }

    @Override
    public Iterator<E> iterator() {
        return new HumanIterator<>(humans);
    }

    public void sortById() {
        Collections.sort(humans, new HumanComparatorById<>());
    }

    public void sortByBirthDate(){ Collections.sort(humans, new HumanCoparatorByBirthDate<>());}


    /**

    public int size(){
        return humans.size();
    }

    public void addHuman(Human human){
        humans.add(human);
    }

    public Human getById(int id){
        for (Human human : humans) {
            if (human.getId() == id){
                return human;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Семейное древо: \n");
        for (Human human : humans) {
            stringBuilder.append(human).append("\n");
        }
        return stringBuilder.toString();
    }

    public FamilyTree(List<Human> humans) {
        this.humans = humans;
    }


    */
}
