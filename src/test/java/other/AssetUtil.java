package other;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import org.junit.Test;

import other.Asset.AssetType;

public class AssetUtil {
    public static int totalAssetValues(final List<Asset> assets){
        return assets.stream().mapToInt(Asset::getValue).sum();
    }

    public static int totalBondValues(final List<Asset> assets){
        return assets.stream()
                     .mapToInt(asset -> asset.getType() == AssetType.BOND ? asset.getValue() : 0)
                     .sum();
    }

    public static int totalAssetValues(final List<Asset> assets, final Predicate<Asset> assetSelector){
        return assets.stream()
                .filter(assetSelector)
                .mapToInt(Asset::getValue)
                .sum();
    }

    final List<Asset> assets = Arrays.asList(
            new Asset(AssetType.BOND, 1000),
            new Asset(AssetType.BOND, 2000),
            new Asset(AssetType.STOCK, 3000),
            new Asset(AssetType.STOCK, 4000)
    );

    @Test
    public void test3(){
        System.out.println(
                "all sum: " + AssetUtil.totalAssetValues(assets, t ->  true )
        );
        System.out.println(
                "stock sum: " + AssetUtil.totalAssetValues(assets, t ->  t.getType() == AssetType.STOCK )
        );
        System.out.println(
                "bond sum: " + AssetUtil.totalAssetValues(assets, t -> t.getType() == AssetType.BOND )
        );
    }

    @Test
    public void test2(){
        System.out.println(
                AssetUtil.totalBondValues(assets)
        );
    }

    @Test
    public void test1(){
        System.out.println(
                "Total of all assets:" + totalAssetValues(assets)
        );
    }

}
