package com.ctci.treesandgraphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

/**
 * You are given a list of projects and a list of dependencies (which is a list of pairs of projects, where the second
 * project is dependent on the first project). All of a project's dependencies must be built before the project is. Find
 * a build order that will allow the projects to be built. If there is no valid build order, return an error.
 * EXAMPLE
 * Input: projects: a, b, c, d, e, f and dependencies: (a, d), (f, b), (b, d), (f, a), (d, c)
 * Output: f, e, a, b, d, c
 *
 * @author rampatra
 * @since 2019-02-21
 */
public class BuildOrder {

    private class Project {
        String name;
        Set<Project> dependencies = new HashSet<>();

        Project(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    private final Map<String, Project> projects = new HashMap<>();

    private void addProjects(Stream<String> projectNames) {
        projectNames.forEach(name -> projects.put(name, new Project(name)));
    }

    /**
     * Adds a directed edge from {@code projectName2} to {@code ProjectName1}. This means {@code projectName2} is
     * dependent on {@code projectName1}, i.e, {@code projectName1} has to be built before {@code projectName2}.
     *
     * @param projectName1 name of project 1
     * @param projectName2 name of project 2
     */
    private void addDependency(String projectName1, String projectName2) {
        Project p1 = projects.get(projectName1);
        Project p2 = projects.get(projectName2);

        if (p1 == null) {
            p1 = new Project(projectName1);
            projects.put(projectName1, p1);
        }
        if (p2 == null) {
            p2 = new Project(projectName2);
            projects.put(projectName2, p2);
        }

        p2.dependencies.add(p1);
    }

    /**
     * Determines the order in which the projects need to be built.
     * Time complexity: TODO
     *
     * @return a list of projects in the order they should be built, the first project should be built first and so on.
     */
    private List<Project> getBuildOrder() {
        Map<String, Project> projectsBuilt = new LinkedHashMap<>(); // linked hashmap is needed to maintain the insertion order

        while (projectsBuilt.size() != projects.size()) {
            // find the projects which are not dependent on any project
            Set<Project> nextProjectsToBuild = getProjectsWithNoDependencies(projectsBuilt);

            // if there are no further independent projects to build, then we can't proceed further
            if (nextProjectsToBuild.size() == 0) {
                throw new IllegalStateException("Error: Projects can't be built.");
            }
            nextProjectsToBuild.forEach(p -> projectsBuilt.put(p.name, p));

            // once a project is built, remove the dependencies from all other projects dependent on this
            removeDependency(nextProjectsToBuild);
        }

        return new ArrayList<>(projectsBuilt.values());
    }

    private Set<Project> getProjectsWithNoDependencies(Map<String, Project> alreadyBuildProjects) {
        Set<Project> unBuiltProjectsWithZeroDependencies = new HashSet<>();

        for (Map.Entry<String, Project> entry : projects.entrySet()) {
            if (entry.getValue().dependencies.size() == 0 && alreadyBuildProjects.get(entry.getKey()) == null) {
                unBuiltProjectsWithZeroDependencies.add(entry.getValue());
            }
        }

        return unBuiltProjectsWithZeroDependencies;
    }

    private void removeDependency(Set<Project> newlyBuiltProjects) {
        projects.forEach((n, p) -> p.dependencies.removeAll(newlyBuiltProjects));
    }


    public static void main(String[] args) {
        /* test case 1
        
               ––––––––––– b
               |           ↑
               ↓           |
               f <–– a <–– d <–– c  
               
            Note: Project "a" is dependent on "f", and project "d" is dependent on "a", and so on.
                  
         */
        BuildOrder buildOrder = new BuildOrder();
        buildOrder.addProjects(Stream.of("a", "b", "c", "d", "e", "f"));
        buildOrder.addDependency("a", "d");
        buildOrder.addDependency("f", "b");
        buildOrder.addDependency("b", "d");
        buildOrder.addDependency("f", "a");
        buildOrder.addDependency("d", "c");
        System.out.println(buildOrder.getBuildOrder());

        // test case 2
        buildOrder = new BuildOrder();
        buildOrder.addProjects(Stream.of("a", "b", "c", "d", "e", "f", "g"));
        buildOrder.addDependency("d", "g");
        buildOrder.addDependency("f", "b");
        buildOrder.addDependency("f", "c");
        buildOrder.addDependency("f", "a");
        buildOrder.addDependency("c", "a");
        buildOrder.addDependency("b", "a");
        buildOrder.addDependency("b", "e");
        buildOrder.addDependency("a", "e");
        System.out.println(buildOrder.getBuildOrder());
    }
}