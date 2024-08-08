# SOURCE: https://github.com/pascaldekloe/colfer/blob/v1.8.1/java/bench/bench.java
static void benchMarshal() {
		Colfer[] testData = newTestData();
		final int n = 20000000;

		long start = System.nanoTime();
		for (int i = 0; i < n; i++) {
			holdSerial = new byte[200];
			testData[i % testData.length].marshal(holdSerial, 0);
		}
		long end = System.nanoTime();

		System.err.printf("%dM marshals avg %dns\n", n / 1000000, (end - start) / n);
	}

	static void benchMarshalReuse() {
		Colfer[] testData = newTestData();
		holdSerial = new byte[Colfer.colferSizeMax];
		final int n = 20000000;

		long start = System.nanoTime();
		for (int i = 0; i < n; i++) {
			testData[i % testData.length].marshal(holdSerial, 0);
		}
		long end = System.nanoTime();

		System.err.printf("%dM marshals with buffer reuse avg %dns\n", n / 1000000, (end - start) / n);
	}
