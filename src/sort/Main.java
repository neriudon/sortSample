package sort;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Main {
	public static void main(String[] args) {
		new Main().sortOk();
		new Main().sortNg();
	}

	public void sortOk() {
		Map<String, SortOrderDto> map = new HashMap<>();
		map.put("id1", new SortOrderDto("id1", 1, "name1"));
		map.put("id2", new SortOrderDto("id2", 2, "name2"));
		map.put("id3", new SortOrderDto("id3", 3, "name3"));
		map.put("id4", new SortOrderDto("id4", 4, "name4"));
		map.put("id5", new SortOrderDto("id5", 5, "name5"));

		List<SortTargetDto> list = new ArrayList<>();
		list.add(new SortTargetDto("shop3", 30000, "id3"));
		list.add(new SortTargetDto("shop2", 20000, "id2"));
		list.add(new SortTargetDto("shop3", 50000, "id5"));
		list.add(new SortTargetDto("shop1", 10000, "id1"));
		list.add(new SortTargetDto("shop3", 40000, "id4"));
		sort(map, list);
	}

	public void sortNg() {
		Map<String, SortOrderDto> map = new HashMap<>();
		map.put("id1", new SortOrderDto("id1", 1, "name1"));
		map.put("id2", new SortOrderDto("id2", 2, "name2"));
		// エラーが起こるようにコメントアウト
		// map.put("id3", new SortOrderDto("id3", 3, "name3"));
		// map.put("id4", new SortOrderDto("id4", 4, "name4"));
		// map.put("id5", new SortOrderDto("id5", 5, "name5"));

		List<SortTargetDto> list = new ArrayList<>();
		list.add(new SortTargetDto("shop3", 30000, "id3"));
		list.add(new SortTargetDto("shop2", 20000, "id2"));
		list.add(new SortTargetDto("shop3", 50000, "id5"));
		list.add(new SortTargetDto("shop1", 10000, "id1"));
		list.add(new SortTargetDto("shop3", 40000, "id4"));
		sort(map, list);
	}

	public void sort(Map<String, SortOrderDto> map, List<SortTargetDto> list) {
		System.out.println("--------------\nソート前\n--------------");
		list.stream().forEach(System.out::println);
		Collections.sort(list,
				Comparator.comparing(SortTargetDto::getShopId)
						.thenComparing(d -> Optional.ofNullable(map.get(d.getId()))
								.orElseThrow(() -> new RuntimeException("order not found for id = " + d.getId() + "."))
								.getOrder()));
		System.out.println("--------------\nソート後\n--------------");
		list.stream().forEach(System.out::println);
	}

	/**
	 * ソート順を定義したdto.
	 *
	 */
	private class SortOrderDto {
		private String id;
		private int order;
		private String name;

		/**
		 * コンストラクタ.
		 *
		 * @param id
		 *            id
		 * @param order
		 *            表示順
		 * @param name
		 *            表示名
		 */
		public SortOrderDto(String id, int order, String name) {
			this.id = id;
			this.order = order;
			this.name = name;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public int getOrder() {
			return order;
		}

		public void setOrder(int order) {
			this.order = order;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}

	/**
	 * {@code SortOrderDto}を参照してソートされるdto.
	 *
	 */
	private class SortTargetDto {
		private String shopId;
		private int salesAmount;
		private String id;

		/**
		 * コンストラクタ.
		 *
		 * @param shopId
		 *            適当なフィールド1
		 * @param salesAmount
		 *            適当なフィールド2
		 * @param id
		 *            SortOrderDtoで参照するid
		 */
		public SortTargetDto(String shopId, int salesAmount, String id) {
			this.shopId = shopId;
			this.salesAmount = salesAmount;
			this.id = id;
		}

		public String getShopId() {
			return shopId;
		}

		public void setShopId(String shopId) {
			this.shopId = shopId;
		}

		public int getSalesAmount() {
			return salesAmount;
		}

		public void setSalesAmount(int salesAmount) {
			this.salesAmount = salesAmount;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String toString() {
			return "shopId: " + this.shopId + ", salesAmount: " + this.salesAmount + ", id: " + this.id + ".";
		}
	}
}
