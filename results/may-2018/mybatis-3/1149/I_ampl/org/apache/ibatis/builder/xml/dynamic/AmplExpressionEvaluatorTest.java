package org.apache.ibatis.builder.xml.dynamic;


import org.apache.ibatis.scripting.xmltags.ExpressionEvaluator;
import org.junit.Assert;
import org.junit.Test;


public class AmplExpressionEvaluatorTest {
    private ExpressionEvaluator evaluator = new ExpressionEvaluator();

    @Test(timeout = 120000)
    public void shouldReturnFalseIfZeroWithScalelitNum79778() throws Exception {
        class Bean {
            @SuppressWarnings("unused")
            public double d = 0.0;
        }
        boolean o_shouldReturnFalseIfZeroWithScalelitNum79778__4 = this.evaluator.evaluateBoolean("d", new Bean());
        Assert.assertFalse(o_shouldReturnFalseIfZeroWithScalelitNum79778__4);
    }

    @Test(timeout = 120000)
    public void shouldReturnFalseIfZeroWithScale() throws Exception {
        class Bean {
            @SuppressWarnings("unused")
            public double d = 0.0;
        }
        boolean o_shouldReturnFalseIfZeroWithScale__4 = this.evaluator.evaluateBoolean("d", new Bean());
        Assert.assertFalse(o_shouldReturnFalseIfZeroWithScale__4);
    }

    @Test(timeout = 120000)
    public void shouldReturnFalseIfZeroWithScalelitNum50830() throws Exception {
        class Bean {
            @SuppressWarnings("unused")
            public double d = 0.0;
        }
        boolean o_shouldReturnFalseIfZeroWithScalelitNum50830__4 = this.evaluator.evaluateBoolean("d", new Bean());
        Assert.assertFalse(o_shouldReturnFalseIfZeroWithScalelitNum50830__4);
    }

    @Test(timeout = 120000)
    public void shouldReturnFalseIfZeroWithScalelitString50818() throws Exception {
        class Bean {
            @SuppressWarnings("unused")
            public double d = 0.0;
        }
        boolean o_shouldReturnFalseIfZeroWithScalelitString50818__4 = this.evaluator.evaluateBoolean("d", new Bean());
        Assert.assertFalse(o_shouldReturnFalseIfZeroWithScalelitString50818__4);
    }

    @Test(timeout = 120000)
    public void shouldReturnFalseIfZeroWithScalelitNum50230() throws Exception {
        class Bean {
            @SuppressWarnings("unused")
            public double d = 0.0;
        }
        boolean o_shouldReturnFalseIfZeroWithScalelitNum50230__4 = this.evaluator.evaluateBoolean("d", new Bean());
        Assert.assertFalse(o_shouldReturnFalseIfZeroWithScalelitNum50230__4);
    }

    @Test(timeout = 120000)
    public void shouldReturnFalseIfZeroWithScalelitString50218() throws Exception {
        class Bean {
            @SuppressWarnings("unused")
            public double d = 0.0;
        }
        boolean o_shouldReturnFalseIfZeroWithScalelitString50218__4 = this.evaluator.evaluateBoolean("d", new Bean());
        Assert.assertFalse(o_shouldReturnFalseIfZeroWithScalelitString50218__4);
    }

    @Test(timeout = 120000)
    public void shouldReturnFalseIfZeroWithScalelitNum12084() throws Exception {
        class Bean {
            @SuppressWarnings("unused")
            public double d = 0.0;
        }
        boolean o_shouldReturnFalseIfZeroWithScalelitNum12084__5 = this.evaluator.evaluateBoolean("d", new Bean());
        Assert.assertFalse(o_shouldReturnFalseIfZeroWithScalelitNum12084__5);
    }
}

