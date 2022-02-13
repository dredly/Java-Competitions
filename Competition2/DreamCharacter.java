public class DreamCharacter {
    private String name;
    private int layer;
    private boolean inLimbo;
    private boolean owner;

    // Constructor
    public DreamCharacter(String name) {
        this.name = name;
        this.layer = 0;
        this.inLimbo = false;
        this.owner = false;
    }

    // Getters
    public String getName() {
        return this.name;
    }

    public int getLayer() {
        return this.layer;
    }

    public boolean isInLimbo() {
        return this.inLimbo;
    }

    public boolean isOwner() {
        return this.owner;
    }

    // Other methods
    public void dream(DreamCharacter[] others) {
        if (!inLimbo) {
            layer++;
            // Check if there are other players in the layer, and if not make player
            // the owner
            boolean othersInLayer = false;
            for (DreamCharacter other : others) {
                if (other.layer == layer) {
                    othersInLayer = true;
                    break;
                }
            }
            if (!othersInLayer) {
                owner = true;
            }
        }
    }

    public void wake(DreamCharacter[] others) {
        if (!inLimbo) {
            if (owner) {
                for (DreamCharacter other : others) {
                    if (other.layer == layer) {
                        other.limbo();
                    }
                }
            }
            layer--;
            owner = false;
        }
    }

    public void limbo() {
        inLimbo = true;
    }

    public void becomeOwner() {
        owner = true;
    }

    @Override
    public String toString() {
        String limboText = inLimbo ? " --- IN LIMBO" : "";
        String layerText = owner ? " owner of layer " : " currently in layer ";
        return name + layerText + layer + limboText;
    }
}