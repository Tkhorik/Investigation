package ru.maven;

/**
 * Created by MaRV on 11/28/2016.
 */
public class Company {
    private Company parent;
    private long employeeCount;
    private int id;

    public Company(int i, final Company parent, long employeeCount) {
        this.id = id;
        this.parent = parent;
        this.employeeCount = employeeCount;
    }

    public Company getParent() {
        return this.parent;
    }

    public long getEmployeeCount() {
        return this.employeeCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Company company = (Company) o;

        return id == company.id;

    }

    @Override
    public int hashCode() {
        return id;
    }
}
