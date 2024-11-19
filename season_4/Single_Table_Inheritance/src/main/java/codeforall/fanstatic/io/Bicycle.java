package codeforall.fanstatic.io;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


    @Entity(name="BicycleSingleTable")
    @DiscriminatorValue("bicycle")
    public class Bicycle extends Vehicle {
        private Integer kms;

        public Integer getKms() {
            return kms;
        }

        public void setKms(Integer kms) {
            this.kms = kms;
        }
    }


