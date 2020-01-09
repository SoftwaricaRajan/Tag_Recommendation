package bic;

class Tag implements Cloneable {

    public String name;
    public double prob;
    public double total;

    public Tag() {
        name = "";
        prob = 0.0;
        total = 0.0;
    }

    public Tag(String name, double total) {
        this.name = name;
        this.total = total;
    }

    @Override
    public String toString() {
        return "(" + name + ", " + prob + ")";
    }

    public static Tag getHighestProbTag(Tag[] tags) {
        for (int i = 0; i < 7; i++) {
            for (int j = i; j < 7; j++) {
                if (tags[i].prob < tags[j].prob) {
                    try {
                        Tag tempTag = (Tag) tags[i].clone();
                        tags[i] = (Tag) tags[j].clone();
                        tags[j] = (Tag) tempTag.clone();

                    } catch (CloneNotSupportedException ex) {
                        System.out.println("Error: " + ex);
                    }
                }
            }
        }
        return tags[0];
    }
}
