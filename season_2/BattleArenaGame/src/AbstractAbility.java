public abstract class AbstractAbility implements Ability {
    protected String name;

    public AbstractAbility(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
