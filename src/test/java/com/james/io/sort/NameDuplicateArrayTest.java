package com.james.io.sort;

import com.james.io.sort.model.Name;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class NameDuplicateArrayTest {

    private static final String IAN = "Ian";
    private static final String BELL = "Bell";
    private static final String BOTHAM = "Botham";
    private static final String CHAPELL = "Chapell";
    private static final String DAVID = "David";
    private static final String GOWER = "Gower";

    private static final Name name1 = new Name.Builder().firstName(IAN).lastName(BELL).build();
    private static final Name name2 = new Name.Builder().firstName(IAN).lastName(BOTHAM).build();
    private static final Name name3 = new Name.Builder().firstName(DAVID).lastName(GOWER).build();
    private static final Name name4 = new Name.Builder().firstName(IAN).lastName(CHAPELL).build();

    @Test
    public void testEliminateDuplicate() {
        final List<Name> names = Stream.of(name1, name2, name3, name4).collect(Collectors.toList());
        NameDuplicateArray nameDuplicateArray = new NameDuplicateArray(names);
        nameDuplicateArray.eliminateDuplicates();
        final List<Name> namesRes = nameDuplicateArray.getNames();
        assertEquals(Stream.of(name3, name1).collect(Collectors.toList()), namesRes);
    }

    @Ignore
    @Test
    public void testEliminateDuplicateBruteForce() {
        final List<Name> names = Stream.of(name1, name2, name3, name4).collect(Collectors.toList());
        NameDuplicateArray nameDuplicateArray = new NameDuplicateArray(names);
        final Set<Name> namesRes = nameDuplicateArray.eliminateDuplicatesBruteForce();
        assertEquals(Stream.of(name3, name1).collect(Collectors.toCollection(LinkedHashSet::new)), namesRes);
    }
}
