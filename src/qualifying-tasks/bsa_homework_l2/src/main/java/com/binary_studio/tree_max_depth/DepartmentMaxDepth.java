package com.binary_studio.tree_max_depth;

import java.util.*;

public final class DepartmentMaxDepth {

	private DepartmentMaxDepth() {
	}

	public static Integer calculateMaxDepth(Department rootDepartment) {
		Queue<Department> children;
		int nodeCount;
		int depth = 1;

		if (rootDepartment == null) {
			return 0;
		}

		children = new LinkedList<>(rootDepartment.subDepartments);

		while (true) {
			nodeCount = children.size();

			if (nodeCount == 0 || !notNullElementsInList(children)) {
				return depth;
			}
			else {
				depth++;
			}

			while (nodeCount > 0) {
				Department temp = children.peek();
				children.poll();

				if (temp != null) {
					if (!temp.subDepartments.isEmpty()) {
						children.addAll(temp.subDepartments);
					}
				}
				nodeCount--;
			}
		}
	}

	private static boolean notNullElementsInList(Queue<Department> list) {
		for (Department temp : list) {
			if (temp != null) {
				return true;
			}
		}
		return false;
	}

}
