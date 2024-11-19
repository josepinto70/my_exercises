package codeforall.fanstatic.io;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;



    @Entity(name="CarSingleTable")
    @DiscriminatorValue("car")
    public class Car extends Vehicle {
        public Integer getGears() {
            return gears;
        }

        public void setGears(Integer gears) {
            this.gears = gears;
        }

        private Integer gears;
    }

