package me.markbacon78.modtools.utils;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemFactory {

    private Material material;
    private int size;
    private short data;
    private String name;
    private List<String> lore;
    private boolean glow;

    private ItemFactory(Material material) {
        this.material = material;
        this.size = 1;
        this.data = 0;
        this.glow = false;
    }

    public static ItemFactory material(Material material) {
        return new ItemFactory(material);
    }

    public ItemFactory amount(int amount) {
        this.size = amount;
        return this;
    }

    public ItemFactory data(short data) {
        this.data = data;
        return this;
    }

    public ItemFactory name(String name) {
        this.name = name;
        return this;
    }

    public ItemFactory lore(List<String> lore) {
        this.lore = lore;
        return this;
    }

    public ItemFactory withGlow() {
        this.glow = true;
        return this;
    }

    public ItemStack build() {
        ItemStack item = new ItemStack(material, size, data);

        ItemMeta meta = item.getItemMeta();

        if(name != null) meta.setDisplayName(name);
        if(lore != null) meta.setLore(lore);
        if(glow)         meta.addEnchant(Enchantment.DURABILITY, 1, false);

        item.setItemMeta(meta);

        return item;
    }

    public Material getMaterial() {
        return material;
    }

    public int getSize() {
        return size;
    }

    public String getName() {
        return name;
    }

    public short getData() {
        return data;
    }

    public List<String> getLore() {
        return lore;
    }

    public boolean isGlow() {
        return glow;
    }

}