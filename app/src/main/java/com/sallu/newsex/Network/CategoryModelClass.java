package com.sallu.newsex.Network;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;




public class CategoryModelClass implements Serializable
{

    @SerializedName("categories")
    @Expose
    private List<Category> categories = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public CategoryModelClass() {
    }

    /**
     *
     * @param categories
     */
    public CategoryModelClass(List<Category> categories) {
        super();
        this.categories = categories;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public class Category implements Serializable
    {

        @SerializedName("id")
        @Expose
        private int id;
        @SerializedName("name")
        @Expose
        private String name;

        /**
         * No args constructor for use in serialization
         *
         */
        public Category() {
        }

        /**
         *
         * @param id
         * @param name
         */
        public Category(int id, String name) {
            super();
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

}}