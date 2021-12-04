# sortSample
ソート順が定義されたMapを参照してソートするサンプルプログラム。  
`SortTargetDto`を`shopId`かつ`id`に紐づく`SortOrderDto`の`order`順にソートする。  
`sortOk()`はソートに成功し、`sortNg()`は`id`に紐づく`SortOrderDto`が足りないため実行時エラーとなる。

# なにこれ
業務で`Comparator`によるソートで想定しない挙動があったため検証のため、簡略化したもの。  
Javaのバージョン違いによる挙動の変化の可能性もあるため、[MergeDoc Project](https://mergedoc.osdn.jp/)から、Java8準拠のEclipse 4.6 Neon, Java11準拠のEclipse2019をJavaがインストールされていないPCにダウンロードして、`Main.java`を実行したが動作の違いは見られなかった。
