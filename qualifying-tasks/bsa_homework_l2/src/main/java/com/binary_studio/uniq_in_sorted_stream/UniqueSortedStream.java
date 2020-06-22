package com.binary_studio.uniq_in_sorted_stream;

import java.util.stream.Stream;

public final class UniqueSortedStream {

	private static long tempRowId;

	private UniqueSortedStream() {
	}

	public static <T> Stream<Row<T>> uniqueRowsSortedByPK(Stream<Row<T>> stream) {
		// return stream.distinct(); // first attempt

		return stream.filter(row -> uniqueProcessing(row.getPrimaryId()));
	}

	private static boolean uniqueProcessing(Long val) {
		if (val.equals(tempRowId)) {
			return false;
		}
		else {
			tempRowId = val;
			return true;
		}
	}

}
