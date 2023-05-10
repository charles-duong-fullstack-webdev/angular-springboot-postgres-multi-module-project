package com.db.h2.console.login.domain.assertj;


import com.db.h2.console.domain.BaseEntity;

/**
 * {@link BaseEntity} specific assertions - Generated by CustomAssertionGenerator.
 * <p>
 * Although this class is not final to allow Soft assertions proxy, if you wish to extend it,
 * extend {@link AbstractBaseEntityAssert} instead.
 */
@javax.annotation.Generated(value = "assertj-assertions-generator")
public class BaseEntityAssert extends AbstractBaseEntityAssert<BaseEntityAssert, BaseEntity> {

    /**
     * Creates a new <code>{@link BaseEntityAssert}</code> to make assertions on actual BaseEntity.
     *
     * @param actual the BaseEntity we want to make assertions on.
     */
    public BaseEntityAssert(BaseEntity actual) {
        super(actual, BaseEntityAssert.class);
    }

    /**
     * An entry point for BaseEntityAssert to follow AssertJ standard <code>assertThat()</code> statements.<br>
     * With a static import, one can write directly: <code>assertThat(myBaseEntity)</code> and get specific assertion with code completion.
     *
     * @param actual the BaseEntity we want to make assertions on.
     * @return a new <code>{@link BaseEntityAssert}</code>
     */
    @org.assertj.core.util.CheckReturnValue
    public static BaseEntityAssert assertThat(BaseEntity actual) {
        return new BaseEntityAssert(actual);
    }
}
