/*
 * Copyright (c) 2018.
 * Copyright 2018 Bradley
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.bkshrader.tutorials.generics;

@SuppressWarnings({"WeakerAccess", "unused"})
public class BinarySearchTree<T extends Comparable<T>> {
    private T value;
    private BinarySearchTree<T> leftChild;
    private BinarySearchTree<T> rightChild;

    public BinarySearchTree(T value) {
        this.value = value;
    }

    public BinarySearchTree() {
    }

    public void insert(T value) {
        if (value == null) return;
        if (this.value == null) {
            this.value = value;
        } else {
            int comparison = value.compareTo(this.value);
            if (comparison > 0) {
                if (this.rightChild == null) this.rightChild = new BinarySearchTree<T>(value);
                else this.rightChild.insert(value);
            } else if (comparison < 0) {
                if (this.leftChild == null) this.leftChild = new BinarySearchTree<T>(value);
                else this.leftChild.insert(value);
            }
        }
    }

    public boolean contains(T value) {
        int comparison = value.compareTo(this.value);
        if (comparison < 0) {
            if (this.leftChild == null) return false;
            else return this.leftChild.contains(value);
        } else if (comparison == 0) {
            return true;
        } else { //comparison > 0
            if (this.rightChild == null) return false;
            else return this.rightChild.contains(value);
        }
    }

    public T getMinimumValue() {
        if (this.leftChild == null) return this.value;
        else return this.leftChild.getMinimumValue();
    }

    public T getMaximumValue() {
        if (this.rightChild == null) return this.value;
        else return this.rightChild.getMaximumValue();
    }
}
