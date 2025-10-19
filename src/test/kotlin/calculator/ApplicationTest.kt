package calculator

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ApplicationTest : NsTest() {
    @Test
    fun `커스텀 구분자 사용1`() {
        assertSimpleTest {
            run("//;\\n1")
            assertThat(output()).contains("결과 : 1")
        }
    }

    @Test
    fun `커스텀 구분자 사용2`() {
        assertSimpleTest {
            run("//@\\n10,50@40")
            assertThat(output()).contains("결과 : 100")
        }
    }

    @Test
    fun `커스텀 구분자 사용3`() {
        assertSimpleTest {
            run("//.\\n10.5.1")
            assertThat(output()).contains("결과 : 16")
        }
    }

    @Test
    fun `커스텀 구분자 미사용1`() {
        assertSimpleTest {
            run("10,20,30")
            assertThat(output()).contains("결과 : 60")
        }
    }

    @Test
    fun `커스텀 구분자 미사용2`() {
        assertSimpleTest {
            run("10,20:30")
            assertThat(output()).contains("결과 : 60")
        }
    }

    @Test
    fun `int 범위를 초과하는 수 입력1` () {
        assertSimpleTest {
            run("100000000000,1")
            assertThat(output()).contains("결과 : 100000000001")
        }
    }

    @Test
    fun `int 범위를 초과하는 수 입력2` () {
        assertSimpleTest {
            run("400000000000,400000000000")
            assertThat(output()).contains("결과 : 800000000000")
        }
    }

    @Test
    fun `예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("-1,2,3") }
        }
    }

    @Test
    fun `커스텀 구분자 마침 문자 잘못 입력1` () {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("//@n-1,2,3") }
        }
    }

    @Test
    fun `커스텀 구분자 마침 문자 잘못 입력2` () {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("//@-1,2,3") }
        }
    }

    @Test
    fun `커스텀 구분자 시작 문자 잘못 입력1`(){
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("/@n-1,2,3") }
        }
    }

    @Test
    fun `커스텀 구분자 시작 문자 잘못 입력2`(){
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("@n-1,2,3") }
        }
    }

    @Test
    fun `커스텀 구분자 시작 문자 잘못 입력3`(){
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("!#@n-1,2,3") }
        }
    }

    @Test
    fun `커스텀 구분자 없이 등록할 때` () {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("//\\n1") }
        }
    }

    @Test
    fun `구분자 띄어쓰기` () {
        assertSimpleTest {
            run("// \\n1 1")
            assertThat(output()).contains("결과 : 2")
        }
    }

    @Test
    fun `소수의 덧셈` () {
        assertSimpleTest {
            run("1.5:2.5")
            assertThat(output()).contains("결과 : 4")
        }
    }

    @Test
    fun `int 범위를 초과하는 소수의 덧셈` () {
        assertSimpleTest {
            run("//?\\n100000000000.5?0.1")
            assertThat(output()).contains("결과 : 100000000000.6")
        }
    }





    override fun runMain() {
        main()
    }
}
