package heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author amrit
 * Merge k lists which are sorted list
 */

public class SortKSortedList {

	public static void main(String[] args) throws InterruptedException {

		List<Integer> l1 = Arrays.asList(1,1,3,4,7);
		List<Integer> l2 = Arrays.asList(1,2,5,8);
		List<Integer> l3 = Arrays.asList(3,6,9);

		List<List<Integer>> list = Arrays.asList(l1, l2, l3);

		new SortKSortedList().getSortedList(list);
	}

	private List<Integer> getSortedList(List<List<Integer>> inputs) throws InterruptedException {
		PriorityQueue<IndexInfo> minHeap = new PriorityQueue<>((a,b)->a.getNum() - b.getNum());

		List<Integer> sortedList = new ArrayList<>();

		// number of lists
		// heap size of length of number of list
		int k = inputs.size();
		IndexInfo indexInfo;

		int i;
		
		// store all the first indexes values of each list in the minHeap
		for (i = 0; i < k; ++i) {
			indexInfo = new IndexInfo(inputs.get(i).get(0), i, 0);
			minHeap.add(indexInfo);
		}

		while (minHeap.size() > 0) {

			indexInfo = minHeap.poll();
			sortedList.add(indexInfo.getNum());

			i = indexInfo.getListNum();
			int nextIndex = indexInfo.getIndex() + 1;

			if (inputs.get(i).size() > nextIndex)
				minHeap.add(new IndexInfo(inputs.get(i).get(nextIndex), i, nextIndex));
		}
		System.out.println(sortedList);
		return sortedList;
	}
}

class IndexInfo {

	private int num; // actual number
	private int listNum; // list number
	private int index; // index of the specific list
	
	public IndexInfo(int num, int listNum, int index) {
		super();
		this.num = num;
		this.listNum = listNum;
		this.index = index;
	}
	
	public int getNum() {
		return num;
	}
	public int getListNum() {
		return listNum;
	}
	public int getIndex() {
		return index;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public void setListNum(int listNum) {
		this.listNum = listNum;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	@Override
	public String toString() {
		return "IndexInfo [num=" + num + ", listNum=" + listNum + ", index=" + index + "]";
	}
}