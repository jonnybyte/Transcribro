package dev.soupslurpr.transcribro.recognitionservice.whisper

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class WhisperModelDownloadTest {

    @Test
    fun `urlFor returns valid URL for tiny`() {
        val url = WhisperModelDownload.urlFor("tiny")
        assertEquals(
            "https://huggingface.co/ggerganov/whisper.cpp/resolve/main/ggml-tiny.bin",
            url
        )
    }

    @Test
    fun `urlFor returns valid URL for base-q8_0`() {
        val url = WhisperModelDownload.urlFor("base-q8_0")
        assertEquals(
            "https://huggingface.co/ggerganov/whisper.cpp/resolve/main/ggml-base-q8_0.bin",
            url
        )
    }

    @Test
    fun `urlFor returns valid URL for large-v3-turbo-q5_0`() {
        val url = WhisperModelDownload.urlFor("large-v3-turbo-q5_0")
        assertEquals(
            "https://huggingface.co/ggerganov/whisper.cpp/resolve/main/ggml-large-v3-turbo-q5_0.bin",
            url
        )
    }

    @Test
    fun `urlFor uses TDRZ source for tdrz models`() {
        val url = WhisperModelDownload.urlFor("small.en-tdrz")
        assertEquals(
            "https://huggingface.co/akashmjn/tinydiarize-whisper.cpp/resolve/main/ggml-small.en-tdrz.bin",
            url
        )
    }

    @Test
    fun `sizeFor returns disk and memory size for tiny`() {
        val size = WhisperModelDownload.sizeFor("tiny")
        assertEquals("77.7 MB", size.disk)
        assertEquals("~273 MB", size.memory)
    }

    @Test
    fun `sizeFor returns disk and memory size for base-q8_0`() {
        val size = WhisperModelDownload.sizeFor("base-q8_0")
        assertEquals("81.8 MB", size.disk)
        assertEquals("~388 MB", size.memory)
    }

    @Test
    fun `sizeFor returns disk and memory size for small`() {
        val size = WhisperModelDownload.sizeFor("small")
        assertEquals("488 MB", size.disk)
        assertEquals("~852 MB", size.memory)
    }

    @Test
    fun `sizeFor returns disk and memory size for medium`() {
        val size = WhisperModelDownload.sizeFor("medium")
        assertEquals("1.53 GB", size.disk)
        assertEquals("~2.1 GB", size.memory)
    }

    @Test
    fun `sizeFor returns disk and memory size for large-v3`() {
        val size = WhisperModelDownload.sizeFor("large-v3")
        assertEquals("3.1 GB", size.disk)
        assertEquals("~3.9 GB", size.memory)
    }

    @Test
    fun `sizeFor returns disk size for tiny-en-q5_1`() {
        val size = WhisperModelDownload.sizeFor("tiny.en-q5_1")
        assertEquals("32.2 MB", size.disk)
        assertEquals("~273 MB", size.memory)
    }

    @Test
    fun `sizeFor returns null disk for unknown model`() {
        val size = WhisperModelDownload.sizeFor("unknown-model")
        assertNull(size.disk)
    }

    @Test
    fun `sizeFor returns null memory for unknown model`() {
        val size = WhisperModelDownload.sizeFor("unknown-model")
        assertNull(size.memory)
    }

    @Test
    fun `sizeFor returns null disk for empty string`() {
        val size = WhisperModelDownload.sizeFor("")
        assertNull(size.disk)
    }

    @Test
    fun `MODELS list contains all expected models`() {
        assertTrue(WhisperModelDownload.MODELS.contains("tiny"))
        assertTrue(WhisperModelDownload.MODELS.contains("large-v3-turbo-q8_0"))
        assertTrue(WhisperModelDownload.MODELS.contains("small.en-tdrz"))
        assertEquals(30, WhisperModelDownload.MODELS.size)
    }

    @Test
    fun `all models in MODELS list return valid URLs`() {
        for (model in WhisperModelDownload.MODELS) {
            val url = WhisperModelDownload.urlFor(model)
            assertTrue(url.startsWith("https://huggingface.co/"), "URL for $model should start with huggingface.co")
            assertTrue(url.endsWith(".bin"), "URL for $model should end with .bin")
        }
    }

    @Test
    fun `all models in MODELS list have corresponding disk size entries`() {
        for (model in WhisperModelDownload.MODELS) {
            val size = WhisperModelDownload.sizeFor(model)
            assertNotNull(size.disk, "Missing disk size for $model")
        }
    }
}
