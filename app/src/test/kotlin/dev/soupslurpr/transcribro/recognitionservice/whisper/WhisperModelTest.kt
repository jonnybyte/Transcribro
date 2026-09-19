package dev.soupslurpr.transcribro.recognitionservice.whisper

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class WhisperModelTest {

    @Test
    fun `DEFAULT is not null`() {
        assertNotNull(WhisperModel.DEFAULT)
    }

    @Test
    fun `DEFAULT is TINY`() {
        assertEquals(WhisperModel.TINY, WhisperModel.DEFAULT)
    }

    @Test
    fun `TINY has correct asset path`() {
        assertEquals(
            "models/whisper/ggml-model-whisper-tiny-q4_0.bin",
            WhisperModel.TINY.assetPath
        )
    }

    @Test
    fun `TINY has correct display name`() {
        assertEquals("Tiny Q4_0 (bundled)", WhisperModel.TINY.displayName)
    }

    @Test
    fun `isCustom returns true for absolute path starting with slash`() {
        assertTrue(WhisperModel.isCustom("/storage/emulated/0/model.bin"))
    }

    @Test
    fun `isCustom returns true for root path`() {
        assertTrue(WhisperModel.isCustom("/model.bin"))
    }

    @Test
    fun `isCustom returns false for relative path`() {
        assertFalse(WhisperModel.isCustom("models/whisper/model.bin"))
    }

    @Test
    fun `isCustom returns false for null`() {
        assertFalse(WhisperModel.isCustom(null))
    }

    @Test
    fun `isCustom returns false for empty string`() {
        assertFalse(WhisperModel.isCustom(""))
    }

    @Test
    fun `isCustom returns false for relative path without subdirectory`() {
        assertFalse(WhisperModel.isCustom("model.bin"))
    }
}
