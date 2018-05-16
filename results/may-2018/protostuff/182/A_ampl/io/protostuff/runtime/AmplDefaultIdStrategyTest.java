package io.protostuff.runtime;


import io.protostuff.Message;
import io.protostuff.Schema;
import org.mockito.Mockito;


public class AmplDefaultIdStrategyTest {
    public static class TestMessage implements Message<AmplDefaultIdStrategyTest.TestMessage> {
        private static final Schema<AmplDefaultIdStrategyTest.TestMessage> SCHEMA = Mockito.mock(Schema.class);

        private TestMessage() {
        }

        @Override
        public Schema<AmplDefaultIdStrategyTest.TestMessage> cachedSchema() {
            return AmplDefaultIdStrategyTest.TestMessage.SCHEMA;
        }
    }

    private final IdStrategy strategy = new DefaultIdStrategy();
}

