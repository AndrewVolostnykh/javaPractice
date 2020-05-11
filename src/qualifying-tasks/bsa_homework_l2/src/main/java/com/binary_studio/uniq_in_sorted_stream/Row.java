package com.binary_studio.uniq_in_sorted_stream;

//You CAN modify this class
public final class Row<RowData> {

	private final Long id;

	public Row(Long id) {
		this.id = id;
	}

	public Long getPrimaryId() {
		return this.id;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}

		Row temp = (Row) obj;

		return this.id.equals(temp.getPrimaryId());
	}

	@Override
	public int hashCode() {
		return this.id.hashCode();
	}

}
