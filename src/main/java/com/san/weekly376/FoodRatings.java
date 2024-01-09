package com.san.weekly376;


import java.util.*;

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */

class Food {
    String name;
    String cuisine;
    int rating;

    public boolean equals(Food f) {
        return this.name.equals(f.name);
    }
    public int hashcode() {
        return name.hashCode();
    }
    public Food(String name, String cuisine, int rating) {
        this.name = name;
        this.cuisine = cuisine;
        this.rating = rating;
    }

    public String getName(){
        return this.name;
    }
    public String getCuisine(){
        return this.cuisine;
    }
    public int getRating(){
        return this.rating;
    }

    public void setRating(int rating){
        this.rating = rating;
    }

    public String toString(){
        return name+" "+cuisine+" "+rating;
    }
}

class FoodRatings {

    Map<String, Food> nameToCuisine = new HashMap<>();
    Map<String, Set<Food>> perCuisineList = new HashMap<>();

    Comparator<Food> comparator = new Comparator<>() {
        public int compare(Food f1, Food f2) {
            return f2.rating - f1.rating;
        }
    };


    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        for(int i=0;i<foods.length;i++) {
            Food f = new Food(foods[i], cuisines[i], ratings[i]);

            Set<Food> list = this.perCuisineList.getOrDefault(cuisines[i], new TreeSet<Food>(this.comparator));

            list.add(f);
            this.perCuisineList.put(cuisines[i], list);
            this.nameToCuisine.put(foods[i], f);
        }
    }

    public void changeRating(String food, int newRating) {
        Food f = this.nameToCuisine.get(food);
        f.setRating(newRating);
//        this.perCuisineList.get(f.getCuisine()).add(f);
    }

    public String highestRated(String cuisine) {
        return this.perCuisineList.get(cuisine).iterator().next().getName();
    }

    public static void main(String[] args) {
        String[] foods = new String[]{"kimchi","miso","sushi","moussaka","ramen","bulgogi"};
        String[] cuisines = new String[]{"korean","japanese","japanese","greek","japanese","korean"};
        int[] ratings = new int[]{9,12,8,15,14,7};
        FoodRatings fr = new FoodRatings(foods, cuisines, ratings);
        System.out.println(fr.highestRated("korean"));
        System.out.println(fr.highestRated("japanese"));
        System.out.println(fr.perCuisineList.get("japanese").size());
        fr.changeRating("sushi", 16);
        System.out.println(fr.highestRated("japanese"));
        System.out.println(fr.perCuisineList.get("japanese").size());
        fr.changeRating("ramen", 16);
        System.out.println(fr.highestRated("japanese"));

    }

    public static void main_(String[] args) {
        Set<Food> q = new TreeSet<>(new Comparator<>() {
            public int compare(Food f1, Food f2) {
                return f2.rating - f1.rating;
            }
        });
        q.add(new Food("a1", "japanes", 10));
        System.out.println(q.iterator().next());
        q.add(new Food("a2", "japanes", 12));
        System.out.println(q.iterator().next());
        Food e = new Food("a3", "japanes", 9);
        q.add(e);
        System.out.println(q.iterator().next());
        e.setRating(100);
        q.add(e);
        System.out.println(q.size());
        System.out.println(q.iterator().next());
    }
}

