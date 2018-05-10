package fr.inria.diversify.utils.json;

/**
 * Override version of fr.inria.diversify.utils.json.ProjectTimeJSON of DSpot
 */
public class ClassTimeJSON {

    public final String fullQualifiedName;
    public final long timeInMs;
    private int numberOfAmplifiedTestMethods;
    private int numberOfTestMethodToBeAmplified;

    public ClassTimeJSON(String fullQualifiedName, long timeInMs) {
        this.fullQualifiedName = fullQualifiedName;
        this.timeInMs = timeInMs;
        this.numberOfAmplifiedTestMethods = 0;
        this.numberOfTestMethodToBeAmplified = 0;
    }

    public int getNumberOfAmplifiedTestMethods() {
        return numberOfAmplifiedTestMethods;
    }

    public void setNumberOfAmplifiedTestMethods(int numberOfAmplifiedTestMethods) {
        this.numberOfAmplifiedTestMethods = numberOfAmplifiedTestMethods;
    }

    public int getNumberOfTestMethodToBeAmplified() {
        return numberOfTestMethodToBeAmplified;
    }

    public void setNumberOfTestMethodToBeAmplified(int numberOfTestMethodToBeAmplified) {
        this.numberOfTestMethodToBeAmplified = numberOfTestMethodToBeAmplified;
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
