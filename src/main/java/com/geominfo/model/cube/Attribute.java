package com.geominfo.model.cube;

/**
 * @author Pu
 * @since 2024/7/11
 */
public class Attribute {

    private  String uniqueId;
    private  String caption;
    private  boolean visible;
    private  String aggregator;
    private  String granularity;
    private  String dataType;
    private  String originDataType;
    private  String secondDataType;
    private  String expression;

    public Attribute() {

    }

    private Attribute(Builder builder) {
        this.uniqueId = builder.uniqueId;
        this.caption = builder.caption;
        this.visible = builder.visible;
        this.aggregator = builder.aggregator;
        this.granularity = builder.granularity;
        this.dataType = builder.dataType;
        this.originDataType = builder.originDataType;
        this.secondDataType = builder.secondDataType;
        this.expression = builder.expression;
    }

    public static class Builder {
        private String uniqueId;
        private String caption;
        private boolean visible = true; // Set default visibility to true
        private  String aggregator;
        private  String granularity;
        private  String dataType;
        private  String originDataType;
        private  String secondDataType;
        private  String expression;

        public Builder uniqueId(String uniqueId) {
            this.uniqueId = uniqueId;
            return this;
        }

        public Builder caption(String caption) {
            this.caption = caption;
            return this;
        }

        public Builder visible(boolean visible) {
            this.visible = visible;
            return this;
        }

        public Builder aggregator(String aggregator) {
            this.aggregator = aggregator;
            return this;
        }

        public Builder granularity(String granularity) {
            this.granularity = granularity;
            return this;
        }

        public Builder dataType(String dataType) {
            this.dataType = dataType;
            return this;
        }

        public Builder originDataType(String originDataType) {
            this.originDataType = originDataType;
            return this;
        }

        public Builder secondDataType(String secondDataType) {
            this.secondDataType = secondDataType;
            return this;
        }

        public Builder expression(String expression) {
            this.expression = expression;
            return this;
        }

        public Attribute build() {
            return new Attribute(this);
        }
    }

    // Getters removed for brevity (same as before)

    @Override
    public String toString() {
        return "Attribute{" +
                "uniqueId='" + uniqueId + '\'' +
                ", caption='" + caption + '\'' +
                ", visible=" + visible +
                ", aggregator='" + aggregator + '\'' +
                ", granularity='" + granularity + '\'' +
                ", dataType='" + dataType + '\'' +
                ", originDataType='" + originDataType + '\'' +
                ", secondDataType='" + secondDataType + '\'' +
                ", expression='" + expression + '\'' +
                '}';
    }
}
