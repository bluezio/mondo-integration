/*******************************************************************************
 * Copyright (c) 2015-2016 University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Antonio Garcia-Dominguez - initial API and implementation
 *******************************************************************************/
package uk.ac.york.mondo.integration.hawk.emf;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Properties;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.ImmutableSet;

import uk.ac.york.mondo.integration.api.EffectiveMetamodelRuleset;

public class EffectiveMetamodelRulesetTest {

	private static final String PROPERTY_EMM_PREFIX = "hawk.effectiveMetamodel";
	private EffectiveMetamodelRulesetSerializer serializer;
	private Properties props;

	@Before
	public void setup() {
		this.serializer = new EffectiveMetamodelRulesetSerializer(PROPERTY_EMM_PREFIX);
		this.props = new Properties();
	}

	@Test
	public void saveLoadEmpty() {
		final EffectiveMetamodelRuleset saved = new EffectiveMetamodelRuleset();
		serializer.save(saved, props);
		final EffectiveMetamodelRuleset loaded = serializer.load(props);
		assertEquals(saved, loaded);
		assertTrue(loaded.isEverythingIncluded());
		assertTrue(loaded.isIncluded("x"));
		assertTrue(loaded.isFullyIncluded("x"));
		assertTrue(loaded.isIncluded("x", "y"));
		assertTrue(loaded.isFullyIncluded("x", "y"));
		assertTrue(loaded.isIncluded("a", "b", "c"));
		assertEquals(ImmutableSet.of(EffectiveMetamodelRuleset.WILDCARD), loaded.getIncludedSlots("f", "g"));
	}

	@Test
	public void saveLoadIncludeMetamodel() {
		final EffectiveMetamodelRuleset saved = new EffectiveMetamodelRuleset();
		saved.include("x");
		serializer.save(saved, props);
		final EffectiveMetamodelRuleset loaded = serializer.load(props);
		assertEquals(saved, loaded);
		assertFalse(loaded.isEverythingIncluded());
		assertTrue(loaded.isIncluded("x"));
		assertTrue(loaded.isFullyIncluded("x"));
		assertTrue(loaded.isIncluded("x", "y"));
		assertTrue(loaded.isFullyIncluded("x", "y"));
		assertTrue(loaded.isIncluded("x", "y", "z"));

		assertFalse(loaded.isIncluded("y"));
		assertFalse(loaded.isFullyIncluded("y"));
		assertFalse(loaded.isIncluded("y"));
		assertFalse(loaded.isFullyIncluded("y"));
		assertFalse(loaded.isIncluded("y", "y"));
		assertFalse(loaded.isFullyIncluded("y", "y"));
		assertFalse(loaded.isIncluded("y", "y", "z"));
	}

	@Test
	public void saveLoadExcludeMetamodel() {
		final EffectiveMetamodelRuleset saved = new EffectiveMetamodelRuleset();
		saved.exclude("x");
		serializer.save(saved, props);
		final EffectiveMetamodelRuleset loaded = serializer.load(props);
		assertEquals(saved, loaded);
		assertFalse(loaded.isEverythingIncluded());
		assertFalse(loaded.isIncluded("x"));
		assertFalse(loaded.isFullyIncluded("x"));
		assertFalse(loaded.isIncluded("x", "y"));
		assertFalse(loaded.isFullyIncluded("x", "y"));
		assertFalse(loaded.isIncluded("x", "y", "z"));
		assertEquals(ImmutableSet.of(), loaded.getIncludedSlots("x", "y"));

		assertTrue(loaded.isIncluded("y"));
		assertTrue(loaded.isFullyIncluded("y"));
		assertTrue(loaded.isIncluded("y"));
		assertTrue(loaded.isFullyIncluded("y"));
		assertTrue(loaded.isIncluded("y", "y"));
		assertTrue(loaded.isFullyIncluded("y", "y"));
		assertTrue(loaded.isIncluded("y", "y", "z"));
	}

	@Test
	public void saveLoadEmptyUnrelated() {
		final EffectiveMetamodelRuleset saved = new EffectiveMetamodelRuleset();
		serializer.save(saved, props);
		props.put("ignore", "me");
		final EffectiveMetamodelRuleset loaded = serializer.load(props);
		assertEquals(saved, loaded);
		assertTrue(loaded.isEverythingIncluded());
	}

	@Test
	public void saveLoadEmptyNoIncludeExcludeSuffix() {
		final EffectiveMetamodelRuleset saved = new EffectiveMetamodelRuleset();
		serializer.save(saved, props);
		props.put(PROPERTY_EMM_PREFIX + "0.0.0.0", "imbad");
		final EffectiveMetamodelRuleset loaded = serializer.load(props);
		assertEquals(saved, loaded);
		assertTrue(loaded.isEverythingIncluded());
	}

	@Test(expected=IllegalArgumentException.class)
	public void saveLoadEmptyTooManyParts() {
		final EffectiveMetamodelRuleset saved = new EffectiveMetamodelRuleset();
		serializer.save(saved, props);
		props.put(PROPERTY_EMM_PREFIX + EffectiveMetamodelRulesetSerializer.INCLUDES_SUFFIX + "0.0.0.0", "imbad");
		serializer.load(props);
	}

	@Test
	public void saveLoadMetamodelWithNoTypes() {
		props.put(PROPERTY_EMM_PREFIX + EffectiveMetamodelRulesetSerializer.INCLUDES_SUFFIX + "0", "http://foo/bar");
		final EffectiveMetamodelRuleset loaded = serializer.load(props);
		assertEquals(new EffectiveMetamodelRuleset(), loaded);
		assertTrue(loaded.isEverythingIncluded());
	}

	@Test
	public void saveLoadOneTypeAllSlotsExplicit() {
		final EffectiveMetamodelRuleset saved = new EffectiveMetamodelRuleset();
		saved.include("x", "y");
		serializer.save(saved, props);
		final EffectiveMetamodelRuleset loaded = serializer.load(props);
		assertEquals(saved, loaded);
		assertFalse(loaded.isEverythingIncluded());
		assertTrue(loaded.isIncluded("x"));
		assertFalse(loaded.isFullyIncluded("x"));
		assertTrue(loaded.isIncluded("x", "y"));
		assertTrue(loaded.isFullyIncluded("x", "y"));
		assertFalse(loaded.isIncluded("x", "z"));
		assertFalse(loaded.isFullyIncluded("x", "z"));
		assertFalse(loaded.isIncluded("y", "x"));
		assertFalse(loaded.isFullyIncluded("y", "x"));
		assertTrue(loaded.isIncluded("x", "y", "z"));
		assertEquals(ImmutableSet.of(), loaded.getIncludedSlots("a", "b"));
	}
	
	@Test
	public void saveLoadSomeTypesSomeSlots() {
		final ImmutableSet<String> empty = ImmutableSet.of();
		final ImmutableSet<String> xzSlots = ImmutableSet.of("a", "b");

		final EffectiveMetamodelRuleset saved = new EffectiveMetamodelRuleset();
		saved.include("x", "y", empty);
		saved.include("x", "z", xzSlots);
		saved.include("u", "w", ImmutableSet.of("f"));
		serializer.save(saved, props);

		final EffectiveMetamodelRuleset loaded = serializer.load(props);
		assertEquals(loaded, saved);
		assertFalse(loaded.isEverythingIncluded());
		assertTrue(loaded.isIncluded("x", "y"));
		assertTrue(loaded.isIncluded("x", "z"));
		assertTrue(loaded.isIncluded("u", "w"));
		assertFalse(loaded.isIncluded("u", "z"));
		assertFalse(loaded.isIncluded("v", "z"));

		assertFalse(loaded.isFullyIncluded("x", "y"));
		assertFalse(loaded.isFullyIncluded("x", "z"));
		assertFalse(loaded.isFullyIncluded("u", "w"));
		assertFalse(loaded.isFullyIncluded("u", "z"));
		assertFalse(loaded.isFullyIncluded("v", "z"));

		assertFalse(loaded.isIncluded("x", "y", "z"));
		assertTrue(loaded.isIncluded("x", "z", "a"));
		assertTrue(loaded.isIncluded("x", "z", "b"));
		assertTrue(loaded.isIncluded("u", "w", "f"));
		assertFalse(loaded.isIncluded("u", "w", "g"));
		assertFalse(loaded.isIncluded("v", "z", "h"));

		assertEquals(empty, loaded.getIncludedSlots("x", "y"));
		assertEquals(xzSlots, loaded.getIncludedSlots("x", "z"));
	}

	@Test
	public void saveLoadIncludeTypeExcludeSlots() {
		final EffectiveMetamodelRuleset saved = new EffectiveMetamodelRuleset();
		saved.include("x", "y");
		saved.exclude("x", "y", ImmutableSet.of("f"));
		serializer.save(saved, props);

		final EffectiveMetamodelRuleset loaded = serializer.load(props);
		assertEquals(loaded, saved);
		assertTrue(loaded.isIncluded("x"));
		assertFalse(loaded.isFullyIncluded("x"));
		assertTrue(loaded.isIncluded("x", "y"));
		assertFalse(loaded.isFullyIncluded("x", "y"));
		assertTrue(loaded.isIncluded("x", "y", "a"));
		assertFalse(loaded.isIncluded("x", "y", "f"));
	}

	@Test
	public void saveLoadIncludeExcludeSlots() {
		final EffectiveMetamodelRuleset saved = new EffectiveMetamodelRuleset();
		saved.include("x", "y", ImmutableSet.of("f", "g"));
		saved.exclude("x", "y", ImmutableSet.of("f"));
		serializer.save(saved, props);

		final EffectiveMetamodelRuleset loaded = serializer.load(props);
		assertEquals(loaded, saved);
		assertTrue(loaded.isIncluded("x"));
		assertFalse(loaded.isFullyIncluded("x"));
		assertTrue(loaded.isIncluded("x", "y"));
		assertFalse(loaded.isFullyIncluded("x", "y"));
		assertTrue(loaded.isIncluded("x", "y", "g"));
		assertFalse(loaded.isIncluded("x", "y", "f"));
		assertEquals(ImmutableSet.of("g"), loaded.getIncludedSlots("x", "y"));
	}

	@Test
	public void saveLoadIncludeMetamodelExcludeTypes() {
		final EffectiveMetamodelRuleset saved = new EffectiveMetamodelRuleset();
		saved.include("x");
		saved.exclude("x", "y");
		serializer.save(saved, props);

		final EffectiveMetamodelRuleset loaded = serializer.load(props);
		assertEquals(loaded, saved);
		assertTrue(loaded.isIncluded("x"));
		assertFalse(loaded.isFullyIncluded("x"));
		assertFalse(loaded.isIncluded("x", "y"));
		assertFalse(loaded.isFullyIncluded("x", "y"));
		assertFalse(loaded.isIncluded("x", "y", "a"));
		assertFalse(loaded.isIncluded("x", "y", "f"));
		assertTrue(loaded.isIncluded("x", "z"));
		assertTrue(loaded.isFullyIncluded("x", "z"));
		assertTrue(loaded.isIncluded("x", "z", "a"));
		assertTrue(loaded.isIncluded("x", "z", "f"));
	}

	@Test
	public void saveLoadIncludeMetamodelExcludeSlots() {
		final EffectiveMetamodelRuleset saved = new EffectiveMetamodelRuleset();
		saved.include("x");
		saved.exclude("x", "y", ImmutableSet.of("f"));
		serializer.save(saved, props);

		final EffectiveMetamodelRuleset loaded = serializer.load(props);
		assertEquals(loaded, saved);
		assertTrue(loaded.isIncluded("x"));
		assertFalse(loaded.isFullyIncluded("x"));
		assertTrue(loaded.isIncluded("x", "y"));
		assertFalse(loaded.isFullyIncluded("x", "y"));
		assertTrue(loaded.isIncluded("x", "y", "a"));
		assertFalse(loaded.isIncluded("x", "y", "f"));
	}

	@Test
	public void removeType() {
		final ImmutableSet<String> empty = ImmutableSet.of();
		final EffectiveMetamodelRuleset saved = new EffectiveMetamodelRuleset();
		saved.include("x", "y", empty);
		saved.include("x", "z", ImmutableSet.of("a", "b"));
		saved.include("u", "w", ImmutableSet.of("f"));
		saved.exclude("x", "y");
		saved.exclude("u", "z");
		saved.exclude("h", "x");
		serializer.save(saved, props);

		final EffectiveMetamodelRuleset loaded = serializer.load(props);
		assertEquals(loaded, saved);
		assertFalse(loaded.isIncluded("x", "y"));
		assertFalse(loaded.isIncluded("h", "x"));
		assertTrue(loaded.isIncluded("x", "z"));
		assertTrue(loaded.isIncluded("u", "w"));

		assertFalse(loaded.isFullyIncluded("x", "y"));
		assertFalse(loaded.isFullyIncluded("h", "x"));
		assertFalse(loaded.isFullyIncluded("x", "z"));
		assertFalse(loaded.isFullyIncluded("u", "w"));
	}

	@Test
	public void copyConstructor() {
		final ImmutableSet<String> empty = ImmutableSet.of();
		final EffectiveMetamodelRuleset original = new EffectiveMetamodelRuleset();
		original.include("x", "y", empty);
		original.include("x", "z", ImmutableSet.of("a", "b"));
		original.include("u", "w", ImmutableSet.of("f"));

		final EffectiveMetamodelRuleset copy = new EffectiveMetamodelRuleset(original);
		assertEquals(original, copy);
	}
}
