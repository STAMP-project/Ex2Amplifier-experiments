package fr.inria.diversify.utils.json;

/**
 * Override version of fr.inria.diversify.utils.json.ProjectTimeJSON of DSpot
 */
public class ClassTimeJSON {

    public final String fullQualifiedName;
    public final long timeInMs;
    private int numberOfAmplifiedTestMethods;

    public ClassTimeJSON(String fullQualifiedName, long timeInMs) {
        this.fullQualifiedName = fullQualifiedName;
        this.timeInMs = timeInMs;
        this.numberOfAmplifiedTestMethods = 0;
    }

    public int getNumberOfAmplifiedTestMethods() {
        return numberOfAmplifiedTestMethods;
    }

    public void setNumberOfAmplifiedTestMethods(int numberOfAmplifiedTestMethods) {
        this.numberOfAmplifiedTestMethods = numberOfAmplifiedTestMethods;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o == null || getClass() != o.getClass()) {
            return false;
        } else {
            ClassTimeJSON that = (ClassTimeJSON) o;
            return fullQualifiedName != null ? fullQualifiedName.equals(that.fullQualifiedName) : that.fullQualifiedName == null;
        }
    }

    @Override
    public int hashCode() {
        return this.fullQualifiedName.hashCode();
    }
}
