# sortSample
ソート順が定義されたMapを参照してソートするサンプルプログラム。  
`SortTargetDto`を`shopId`かつ`id`に紐づく`SortOrderDto`の`order`順にソートする。  
`sortOk()`はソートに成功し、`sortNg()`は`id`に紐づく`SortOrderDto`が足りないため実行時エラーとなる。

# なにこれ
業務で`Comparator`によるソートで想定しない挙動があったため検証のため、簡略化したもの。  
Javaのバージョン違いによる挙動の変化の可能性もあるため、[MergeDoc Project](https://mergedoc.osdn.jp/)から、Java8準拠のEclipse 4.6 Neon, Java11準拠のEclipse2019をJavaがインストールされていないPCにダウンロードして、`Main.java`を実行したが動作の違いは見られなかった。

# 出力結果
## Java8
```txt
--------------
ソート前
--------------
shopId: shop3, salesAmount: 30000, id: id3.
shopId: shop2, salesAmount: 20000, id: id2.
shopId: shop3, salesAmount: 50000, id: id5.
shopId: shop1, salesAmount: 10000, id: id1.
shopId: shop3, salesAmount: 40000, id: id4.
--------------
ソート後
--------------
shopId: shop1, salesAmount: 10000, id: id1.
shopId: shop2, salesAmount: 20000, id: id2.
shopId: shop3, salesAmount: 30000, id: id3.
shopId: shop3, salesAmount: 40000, id: id4.
shopId: shop3, salesAmount: 50000, id: id5.
--------------
ソート前
--------------
shopId: shop3, salesAmount: 30000, id: id3.
shopId: shop2, salesAmount: 20000, id: id2.
shopId: shop3, salesAmount: 50000, id: id5.
shopId: shop1, salesAmount: 10000, id: id1.
shopId: shop3, salesAmount: 40000, id: id4.
Exception in thread "main" java.lang.RuntimeException: order not found for id = id5.
	at sort.Main.lambda$1(Main.java:57)
	at java.util.Optional.orElseThrow(Optional.java:290)
	at sort.Main.lambda$0(Main.java:57)
	at java.util.Comparator.lambda$comparing$77a9974f$1(Comparator.java:469)
	at java.util.Comparator.lambda$thenComparing$36697e65$1(Comparator.java:217)
	at java.util.TimSort.binarySort(TimSort.java:296)
	at java.util.TimSort.sort(TimSort.java:221)
	at java.util.Arrays.sort(Arrays.java:1512)
	at java.util.ArrayList.sort(ArrayList.java:1454)
	at java.util.Collections.sort(Collections.java:175)
	at sort.Main.sort(Main.java:54)
	at sort.Main.sortNg(Main.java:48)
	at sort.Main.main(Main.java:13)
```

## Java11
```txt
--------------
ソート前
--------------
shopId: shop3, salesAmount: 30000, id: id3.
shopId: shop2, salesAmount: 20000, id: id2.
shopId: shop3, salesAmount: 50000, id: id5.
shopId: shop1, salesAmount: 10000, id: id1.
shopId: shop3, salesAmount: 40000, id: id4.
--------------
ソート後
--------------
shopId: shop1, salesAmount: 10000, id: id1.
shopId: shop2, salesAmount: 20000, id: id2.
shopId: shop3, salesAmount: 30000, id: id3.
shopId: shop3, salesAmount: 40000, id: id4.
shopId: shop3, salesAmount: 50000, id: id5.
--------------
ソート前
--------------
shopId: shop3, salesAmount: 30000, id: id3.
shopId: shop2, salesAmount: 20000, id: id2.
shopId: shop3, salesAmount: 50000, id: id5.
shopId: shop1, salesAmount: 10000, id: id1.
shopId: shop3, salesAmount: 40000, id: id4.
Exception in thread "main" java.lang.RuntimeException: order not found for id = id5.
	at SortSample/sort.Main.lambda$3(Main.java:58)
	at java.base/java.util.Optional.orElseThrow(Optional.java:408)
	at SortSample/sort.Main.lambda$2(Main.java:58)
	at java.base/java.util.Comparator.lambda$comparing$77a9974f$1(Comparator.java:469)
	at java.base/java.util.Comparator.lambda$thenComparing$36697e65$1(Comparator.java:217)
	at java.base/java.util.TimSort.binarySort(TimSort.java:296)
	at java.base/java.util.TimSort.sort(TimSort.java:221)
	at java.base/java.util.Arrays.sort(Arrays.java:1515)
	at java.base/java.util.ArrayList.sort(ArrayList.java:1749)
	at java.base/java.util.Collections.sort(Collections.java:179)
	at SortSample/sort.Main.sort(Main.java:55)
	at SortSample/sort.Main.sortNg(Main.java:49)
	at SortSample/sort.Main.main(Main.java:14)
  ```
