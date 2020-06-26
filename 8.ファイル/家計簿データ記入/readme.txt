連絡事項が二つ
１.item関連に関して
２．テスト用データについて


１．item関連に関しての追記があります

ItemDao
PgItemDao

List<Item> itemNameFindForItemsId(Integer itemsId)メソッドを追記
処理はPgItemDaoに実装しています


ItemService 
ItemServiceImpl

String itemsIdConvertItemName(Integer itemsId)メソッドを追記
処理はItemServiceImplに実装しています