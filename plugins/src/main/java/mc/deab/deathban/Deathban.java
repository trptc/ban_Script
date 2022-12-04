package mc.deab.deathban;

        import java.time.Instant;
        import java.util.Date;
        import org.bukkit.BanList;
        import org.bukkit.Bukkit;
        import org.bukkit.entity.Player;
        import org.bukkit.event.EventHandler;
        import org.bukkit.event.Listener;
        import org.bukkit.event.entity.PlayerDeathEvent;
        import org.bukkit.plugin.Plugin;
        import org.bukkit.plugin.java.JavaPlugin;

public class Deathban extends JavaPlugin implements Listener {

    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, (Plugin) this);
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        Player p = (Player) event.getEntity();
        Bukkit.getBanList(BanList.Type.NAME).addBan(p.getDisplayName(), "Died", Date.from(Instant.now().plusSeconds(86400)), null);
        p.kickPlayer("You have been banned for 24 hours cause you died!");
    }
}