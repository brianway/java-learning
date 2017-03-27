package com.brianway.learning.java8.effective.optional;

import java.util.Optional;

/**
 * Optional 用法:
 * - 使用 map 从 Optional 对象提取和转换值
 * - 使用 flatMap 链接 Optional 对象
 * - 两个 Optional 对象的组合
 * - 使用 filter 剔除特定值
 */
public class OptionalMain {

    public static void main(String[] args) {
        Optional<Person> person = Optional.of(new Person());
        //Optional<Person> person2 = Optional.empty();
        String name = getCarInsuranceName(person);
        System.out.println(name);
    }

    public static String getCarInsuranceName(Optional<Person> person) {
        return person.flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("Unknown");
    }

    public Insurance findCheapestInsurance(Person person, Car car) {
        //省略业务逻辑
        Insurance cheapestCompany = new Insurance();
        return cheapestCompany;
    }

    public Optional<Insurance> nullSafeFindCheapestInsurance(Optional<Person> person, Optional<Car> car) {
        return person.flatMap(
                p -> car.map(
                        c -> findCheapestInsurance(p, c)));
    }

    public void PrintIfWithName(String name) {
        Optional<Insurance> optInsurance = Optional.of(new Insurance());
        optInsurance.filter(insurance -> name.equals(insurance.getName()))
                .ifPresent(x -> System.out.println("ok"));
    }
}
