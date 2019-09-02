/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 ~ Copyright 2019
 ~
 ~ Licensed under the Apache License, Version 2.0 (the "License");
 ~ you may not use this file except in compliance with the License.
 ~ You may obtain a copy of the License at
 ~
 ~     http://www.apache.org/licenses/LICENSE-2.0
 ~
 ~ Unless required by applicable law or agreed to in writing, software
 ~ distributed under the License is distributed on an "AS IS" BASIS,
 ~ WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 ~ See the License for the specific language governing permissions and
 ~ limitations under the License.
 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
package com.adobe.cq.wcm.core.components.internal.services.embed.oembed;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.adobe.cq.wcm.core.components.models.embed.Embed;
import com.adobe.cq.wcm.core.components.models.embed.oembed.OEmbedClient;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

class OEmbedUrlProcessorTest {

    @Test
    void test() {
        OEmbedUrlProcessor processor = new OEmbedUrlProcessor();

        OEmbedClient mockClient = Mockito.mock(OEmbedClient.class);
        Mockito.when(mockClient.getProvider("something")).thenReturn("Test");
        Mockito.when(mockClient.getResponse("something")).thenReturn(new OEmbedResponseImpl());
        processor.oEmbedClient = mockClient;

        Embed.UrlProcessor.Result result = processor.process("something");
        assertNotNull(result);
        assertEquals(OEmbedUrlProcessor.NAME, result.getProcessor());
        assertEquals("Test", result.getOptions().get("provider"));
        assertNotNull(result.getOptions().get("response"));

        assertNull(processor.process("anything"));
    }
}
