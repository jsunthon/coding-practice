package com.james.io.sort;

import com.james.io.sort.model.Name;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Solution for problem 14.3 of EPI
 */
public class NameDuplicateArray {

  private final List<Name> names;

  public NameDuplicateArray(List<Name> names) {
    this.names = names;
  }

  /**
   * O(n) time O(n) space
   */
  public Set<Name> eliminateDuplicatesBruteForce() {
    return names.stream().collect(Collectors.toCollection(LinkedHashSet::new));
  }

  /**
   * O(n log n) time O(1) space
   */
  public void eliminateDuplicates() {
    Collections.sort(names);
    int lastValidInd = 0;
    Name lastValidName;
    Name currName;
    for (int curr = 1; curr < names.size(); curr++) {
      lastValidName = names.get(lastValidInd);
      currName = names.get(curr);
      if (!currName.getFirstName().equals(lastValidName.getFirstName())) {
        names.set(++lastValidInd, currName);
      }
    }
    names.subList(lastValidInd + 1, names.size()).clear();
  }

  public List<Name> getNames() {
    return names;
  }
}
