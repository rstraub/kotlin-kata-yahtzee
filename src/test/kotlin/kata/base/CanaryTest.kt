package kata.base

import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.sequences.contain
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldContain
import io.kotest.matchers.string.shouldNotContain
import io.mockk.every
import io.mockk.mockk

class CanaryTest : WordSpec({
    "Canary" should {
        "fail" {
            true shouldBe true
        }

        "mock" {
            val mock = mockk<App>()
            every { mock.hello() } returns "Goodbye, World!"

            mock.hello() shouldContain "Goodbye"
            mock.hello() shouldNotContain "Hello"
        }
    }
})
