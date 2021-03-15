package com.oheia.design.builder;

public class MIlkTea {
    private final String type;
    private final String size;
    private final boolean pearl;
    private final boolean ice;

    public MIlkTea(Builder builder) {
        this.type = builder.type;
        this.size = builder.size;
        this.pearl = builder.pearl;
        this.ice = builder.ice;
    }

    public String getType() {
        return type;
    }

    public String getSize() {
        return size;
    }

    public boolean isPearl() {
        return pearl;
    }

    public boolean isIce() {
        return ice;
    }

    @Override
    public String toString() {
        return "MIlkTea{" +
                "type='" + type + '\'' +
                ", size='" + size + '\'' +
                ", pearl=" + pearl +
                ", ice=" + ice +
                '}';
    }

    public static class Builder {
        private final String type;
        private String size = "中杯";
        private boolean pearl = true;
        private boolean ice = false;

        public Builder(String type) {
            this.type = type;
        }

        public Builder setSize(String size) {
            this.size = size;
            return this;
        }

        public Builder setPearl(boolean pearl) {
            this.pearl = pearl;
            return this;
        }

        public Builder setIce(boolean ice) {
            this.ice = ice;
            return this;
        }

        public MIlkTea build(){
            return new MIlkTea(this);
        }
    }

}
