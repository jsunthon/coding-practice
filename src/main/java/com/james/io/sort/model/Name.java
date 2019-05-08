package com.james.io.sort.model;

// immutable name using the builder pattern
public class Name implements Comparable<Name> {
    private final String firstName;

    private final String lastName;

    public static class Builder {
        private String firstName;
        private String lastName;

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Name build() {
            return new Name(this);
        }
    }

    private Name(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
    }

    @Override
    public int compareTo(Name other) {
        int firstNameCmp = firstName.compareTo(other.firstName);
        if (firstNameCmp != 0) {
            return firstNameCmp;
        }

        return lastName.compareTo(other.lastName);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

//    @Override
//    public boolean equals(Object other) {
//        if (this == other) {
//            return true;
//        }
//
//        if (!(other instanceof Name)) {
//            return false;
//        }
//
//        Name otherName = (Name) other;
//
//        return Objects.equals(firstName, otherName.firstName);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hashCode(firstName);
//    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
