package io.protostuff;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;


public class AmplLowCopyProtobufOutputTest {
    private void deserTest(Message origMsg, Schema sch, ByteBuffer buf) throws IOException {
        ByteBufferInput input = new ByteBufferInput(buf, false);
        Object newM = sch.newMessage();
        sch.mergeFrom(input, newM);
        Assert.assertEquals(origMsg, newM);
    }

    private ByteBuffer testObj(Message msg, Schema sch) throws IOException {
        ByteArrayOutputStream controlStream = new ByteArrayOutputStream();
        LinkedBuffer linkedBuffer = LinkedBuffer.allocate(512);
        ProtobufIOUtil.writeTo(controlStream, msg, sch, linkedBuffer);
        byte[] controlData = controlStream.toByteArray();
        LowCopyProtobufOutput lcpo = new LowCopyProtobufOutput();
        sch.writeTo(lcpo, msg);
        List<ByteBuffer> testDatas = lcpo.buffer.finish();
        Assert.assertEquals(1, testDatas.size());
        ByteBuffer testData = testDatas.get(0);
        byte[] testByteArray = new byte[testData.remaining()];
        testData.get(testByteArray);
        Assert.assertTrue(Arrays.equals(controlData, testByteArray));
        System.out.println(("ctrl len = " + (controlData.length)));
        System.out.println(("test len = " + (testByteArray.length)));
        System.out.println(("test size() = " + (lcpo.buffer.size())));
        System.out.println(("test buff count = " + (lcpo.buffer.buffers.size())));
        testData.rewind();
        return testData;
    }
}

