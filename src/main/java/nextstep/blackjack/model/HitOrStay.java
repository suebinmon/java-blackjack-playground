package nextstep.blackjack.model;

import java.util.Arrays;

public enum HitOrStay {
	HIT("y"),
	STAY("n");

	private final String code;

	HitOrStay(String code) {
		this.code = code;
	}

	public static HitOrStay findBy(String code) {
		return Arrays.stream(values())
			.filter(e -> e.code.equals(code))
			.findFirst()
			.orElseThrow(IllegalArgumentException::new);
	}
}
