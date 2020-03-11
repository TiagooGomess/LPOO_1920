package com.aor.numbers;

public class DivisibleByFilter implements IListFilter {

    private Integer integer;
    DivisibleByFilter(Integer integer) {
        this.integer = integer;
    }

    @Override
    public boolean accept(Integer number) {
        return number % this.integer == 0 || number == 1;
    }
}
